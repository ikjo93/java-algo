import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    static int[] parents = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        StringTokenizer st;
        for (int testCase = 1; testCase <= t; testCase++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
            Arrays.fill(parents, -1);

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = a;
                while (st.hasMoreTokens()) {
                    b = Integer.parseInt(st.nextToken());
                }
                union(a, b);
            }

            int count = 0;
            boolean[] visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                int parent = findParent(i);
                if (!visited[parent]) {
                    visited[parent] = true;
                    count++;
                }
            }

            result.append('#').append(testCase).append(' ').append(count).append('\n');
        }

        System.out.println(result);
    }

    private static int findParent(int node) {
        if (parents[node] == -1) {
            return node;
        } else if (parents[node] != node) {
            return parents[node] = findParent(parents[node]);
            // h의 부모는 e, e의 부모는 d, d의 부모는 a -> d의 부모에 a 할당 -> e의 부모에 d의 부모인 a 할당, h의 부모에 e의 부모인 a 할당
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
}
