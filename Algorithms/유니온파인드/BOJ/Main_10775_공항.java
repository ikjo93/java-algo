import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        int[] parents = new int[g + 1];
        for (int i = 1; i <= g; i++) {
            parents[i] = i;
        }

        int result = 0;
        for (int i = 0; i < p; i++) {
            int plane = Integer.parseInt(br.readLine());

            int root = findParent(parents, plane);
            if (root != 0) {
                result++;
                union(parents, root, root - 1);
            } else {
                break;
            }
        }

        System.out.println(result);
    }

    private static int findParent(int[] parents, int node) {
        if (parents[node] == node) {
            return node;
        }

        return parents[node] = findParent(parents, parents[node]);
    }

    private static void union(int[] parents, int a, int b) {
        int n1 = findParent(parents, a);
        int n2 = findParent(parents, b);

        if (n1 > n2) {
            parents[n1] = n2;
        } else {
            parents[n2] = n1;
        }
    }
}
