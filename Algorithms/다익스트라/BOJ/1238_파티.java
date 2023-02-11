import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static int result = 0;
    static final int INF = (int) 2e9;
    static ArrayList<ArrayList<Node>> towns = new ArrayList<>();
    static int[] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken());

        times = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            towns.add(new ArrayList<>());
        }

        int start, end, time;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            time = Integer.parseInt(st.nextToken());

            towns.get(start).add(new Node(end, time));
        }

        int temp;
        for (int i = 1; i <= n; i++) {
            if (i == x) continue;

            Arrays.fill(times, INF);

            dijkstra(i);

            temp = times[x];

            Arrays.fill(times, INF);

            dijkstra(x);

            temp += times[i];

            result = Math.max(result, temp);
        }


        System.out.println(result);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        times[start] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int time = node.getTime();
            int now = node.getIndex();

            if (times[now] < time) continue;

            for (int i = 0; i < towns.get(now).size(); i++) {
                int cost = times[now] + towns.get(now).get(i).getTime();
                int index = towns.get(now).get(i).getIndex();
                if (cost < times[index]) {
                    times[index] = cost;
                    pq.add(new Node(index, cost));
                }
            }
        }
    }

    private static class Node implements Comparable<Node> {
        private final int index;
        private final int time;

        public Node(int index, int time) {
            this.index = index;
            this.time = time;
        }

        public int getIndex() {
            return this.index;
        }

        public int getTime() {
            return this.time;
        }

        @Override
        public int compareTo(Node other) {
            return this.time - other.time;
        }
    }
}
