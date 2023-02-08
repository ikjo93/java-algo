/* 풀이 1 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<List<Integer>> graph;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            test();
        }

        System.out.println(result);
    }

    private static void test() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[1001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        int number = 0;

        while (!queue.isEmpty()) {
            int pres = queue.poll();

            for (int next : graph.get(pres)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    number++;
                }
            }
        }

        result.append(number).append('\n');
    }
}

/* 풀이 2 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            test();
        }

        System.out.println(result);
    }

    private static void test() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            br.readLine();
        }

        result.append(n - 1).append('\n');
    }
}
