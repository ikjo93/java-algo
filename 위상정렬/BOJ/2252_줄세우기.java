import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDepth = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            inDepth[end]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (inDepth[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.append(node).append(' ');

            for (Integer next : graph.get(node)) {
                if (--inDepth[next] == 0) {
                    queue.add(next);
                }
            }
        }

        System.out.println(result);
    }
}
