import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder result = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        List<Edge>[] graph = new ArrayList[100_001];
        boolean[] visited = new boolean[100_001];
        for (int j = 1; j < 100_001; j++) {
            graph[j] = new ArrayList<>();
        }
        
        for (int i = 1; i <= t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
            
            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()),
                        b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
                graph[a].add(new Edge(b, c));
                graph[b].add(new Edge(a, c));
            }

            result.append('#').append(i).append(' ').append(prim(graph, visited, 1, v)).append('\n');

            for (int j = 1; j < 100_001; j++) {
                graph[j].clear();
            }
            
            Arrays.fill(visited, false);
        }

        System.out.println(result);
    }

    public static long prim(List<Edge>[] graph, boolean[] visited, int start, int v) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        long distance = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int next = edge.w;
            int cost = edge.cost;

            if (visited[next]) continue;

            visited[next] = true;
            distance += cost;

            for (Edge e : graph[next]) {
                if (!visited[e.w]) {
                    pq.add(e);
                }
            }
        }

        return distance;
    }

    private static class Edge implements Comparable<Edge> {
        int w;
        int cost;

        Edge(int w, int cost) {
            this.w = w;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }
}
