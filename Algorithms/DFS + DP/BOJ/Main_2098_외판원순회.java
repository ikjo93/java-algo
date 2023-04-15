import java.io.*;
import java.util.*;

public class Main {

    static int n, exit, INF = Integer.MAX_VALUE / 100;
    static int[][] dist, memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        exit = (1 << n) - 1;
        dist = new int[n][n];
        memo = new int[n][1 << n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }

            Arrays.fill(memo[i], -1);
        }

        System.out.println(tsp(0, 1));
    }

    private static int tsp(int now, int visited) {
        if (visited == exit) {
            if (dist[now][0] == 0) {
                return INF;
            }

            return dist[now][0];
        }

        if (memo[now][visited] != -1) {
            return memo[now][visited];
        }

        memo[now][visited] = INF;

        for (int i = 0; i < n; i++) {
            if ((visited & (1 << i)) == 0 && dist[now][i] > 0) {
                int temp = tsp(i, visited | 1 << i) + dist[now][i];
                memo[now][visited] = Math.min(memo[now][visited], temp);
            }
        }

        return memo[now][visited];
    }
}
