import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static List<List<Node>> graph;
    static long[] dist;
    static final long INF = 600_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()),
            m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        dist = new long[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int start, end, cost;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, cost));
        }

        StringBuilder result = new StringBuilder();

        if (bf(n)) {
            for (int i = 2; i <= n; i++) {
                if (dist[i] == INF) {
                    result.append(-1);
                } else {
                    result.append(dist[i]);
                }
                result.append("\n");
            }
        } else {
            result.append(-1);
        }

        System.out.println(result);
    }

    private static boolean bf(int n) {
        Arrays.fill(dist, INF);
        dist[1] = 0;
        boolean updated = false;

        for (int i = 1; i < n; i++) {
            updated = false;
            for (int j = 1; j <= n; j++) {
                for (Node node : graph.get(j)) {
                    if (dist[j] != INF && dist[node.index] > dist[j] + node.cost) {
                        dist[node.index] = dist[j] + node.cost;
                        updated = true;
                    }
                }
            }

            if (!updated) {
                break;
            }
        }

        if (updated) {
            for (int i = 1; i <= n; i++) {
                for (Node node : graph.get(i)) {
                    if (dist[node.index] > dist[i] + node.cost) {
                        return false;
                    }
                }
            }
        }

        return true;
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
