import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Edge> edges = new ArrayList<>();
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            edges.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        parents = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parents[i] = i;
        }

        Collections.sort(edges);

        int result = 0;
        for (Edge edge : edges) {
            if (findParent(edge.a) != findParent(edge.b)) {
                union(edge.a, edge.b);
                result += edge.cost;
            }
        }

        System.out.println(result);
    }

    private static int findParent(int node) {
        if (node == parents[node]) {
            return node;
        }

        return parents[node] = findParent(parents[node]);
    }

    private static void union(int a, int b) {
        a = findParent(a); // a의 루트 노드를 찾은 결과
        b = findParent(b); // b의 루트 노드를 찾은 결과
        if (a > b) parents[a] = b; // a가 b를 부모 노드로 설정
        else parents[b] = a; // b가 a를 부모 노드로 설정
        // 큰 루트 노드가 작은 루트 노드를 가르킴
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
            return this.cost - o.cost;
        }
    }
}
