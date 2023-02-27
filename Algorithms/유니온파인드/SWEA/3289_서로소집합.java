import java.io.*;
import java.util.Arrays;

public class Solution {

    static int[] parents = new int[1_000_001];
    public static void main(String[] args) throws IOException {
        int t = read();
        StringBuilder result = new StringBuilder();
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = read(), m = read();
            Arrays.fill(parents, -1);

            result.append('#').append(testCase).append(' ');

            for (int i = 0; i < m; i++) {
                int o = read();
                int a = read();
                int b = read();

                if (o == 0) {
                    union(a, b);
                } else {
                    if (findParent(a) == findParent(b)) {
                        result.append(1);
                    } else {
                        result.append(0);
                    }
                }
            }

            result.append('\n');
        }

        System.out.println(result);
    }

    private static int findParent(int node) {
        if (parents[node] == -1) {
            return node;
        } else if (parents[node] != node) {
            return parents[node] = findParent(parents[node]);
        }

        return node;
    }

    private static void union(int a, int b) {
        int ap = findParent(a);
        int bp = findParent(b);

        if (ap > bp) {
            parents[ap] = bp;
        } else {
            parents[bp] = ap;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() - 48;
        while ((c = System.in.read()) > 32) {
            n = 10 * n + c - 48;
        }
        return n;
    }
}
