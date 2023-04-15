import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] weights;
    static int[] values;
    static int[][] memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        weights = new int[n];
        values = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        memo = new int[n][k + 1];

        System.out.println(knapsack(n - 1, k));
    }

    private static int knapsack(int bag, int weight) {
        if (bag < 0) {
            return 0;
        }

        if (memo[bag][weight] > 0) {
            return memo[bag][weight];
        }

        int val1 = 0;
        if (weight >= weights[bag]) {
            val1 = knapsack(bag - 1, weight - weights[bag]) + values[bag];
        }
        int val2 = knapsack(bag - 1, weight);

        return memo[bag][weight] = Math.max(val1, val2);
    }
}
