import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Network> networks = new ArrayList<>();
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            networks.add(new Network(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        Collections.sort(networks);

        int result = 0;
        for (Network network : networks) {
            if (findParent(network.a) != findParent(network.b)) {
                union(network.a, network.b);
                result += network.cost;
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
        a = findParent(a);
        b = findParent(b);
        if (a > b) parents[a] = b;
        else parents[b] = a;
    }

    private static class Network implements Comparable<Network> {
        int a;
        int b;
        int cost;

        public Network(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Network o) {
            return this.cost - o.cost;
        }
    }
}
