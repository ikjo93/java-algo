import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        StringBuilder result = new StringBuilder();

        int command, a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            command = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (command == 0) {
                union(a, b);
            } else {
                if (findParent(a) == findParent(b)) {
                    result.append("YES\n");
                } else {
                    result.append("NO\n");
                }
            }
        }

        System.out.println(result);
    }

    private static int findParent(int x) {
        if (parents[x] != x) {
            parents[x] = findParent(parents[x]);
        }

        return parents[x];
    }

    private static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }
}
