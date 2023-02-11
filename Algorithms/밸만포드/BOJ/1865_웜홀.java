import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<List<Node>> graph;
    static StringBuilder result = new StringBuilder();
    static final int INF = 250_000_000;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            test();
        }

        System.out.println(result);
    }

    private static void test() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()),
            m = Integer.parseInt(st.nextToken()),
            w = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, c));
            graph.get(e).add(new Node(s, c));
        }

        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, -c));
        }

        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for (int i = 1; i < n; i++) {
            boolean update = true;
            for (int j = 1; j <= n; j++) {
                for (Node node : graph.get(j)) {
                    if (dist[node.index] > dist[j] + node.cost) {
                        dist[node.index] = dist[j] + node.cost;
                        update = false;
                    }
                }
            }

            if (update) {
                result.append("NO\n");
                return;
            }
        }

        for (int j = 1; j <= n; j++) {
            for (Node node : graph.get(j)) {
                if (dist[node.index] > dist[j] + node.cost) {
                    result.append("YES\n");
                    return;
                }
            }
        }

        result.append("NO\n");
    }

    private static class Node {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}
