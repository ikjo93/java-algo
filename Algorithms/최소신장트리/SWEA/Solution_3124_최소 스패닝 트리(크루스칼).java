import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        int[] parents = new int[100_001];

        for (int i = 1; i <= t; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
            Arrays.fill(parents, -1);

            List<Edge> edges = new ArrayList<>();

            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                edges.add(new Edge(Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            Collections.sort(edges);

            long distance = 0;
            for (Edge edge : edges) {
                if (findParent(parents, edge.a) != findParent(parents, edge.b)) {
                    union(parents, edge.a, edge.b);
                    distance += edge.cost;
                }
            }

            result.append('#').append(i).append(' ').append(distance).append('\n');
        }

        System.out.println(result);
    }

    private static int findParent(int[] parents, int node) {
        if (parents[node] == -1) {
            return node;
        } else if (parents[node] != node) {
            return parents[node] = findParent(parents, parents[node]);
        }

        return node;
    }

    private static void union(int[] parents, int a, int b) {
        int ap = findParent(parents, a);
        int bp = findParent(parents, b);

        if (ap > bp) {
            parents[ap] = bp;
        } else {
            parents[bp] = ap;
        }
    }

    private static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int cost;

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }
}
