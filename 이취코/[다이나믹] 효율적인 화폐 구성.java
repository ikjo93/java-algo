import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] coins = new int[n];
        int[] memo = new int[m + 1];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        Arrays.fill(memo, 10001);

        memo[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= m; j++) {
                memo[j] = getMinVal(memo[j], memo[j - coins[i]] + 1);
            }
        }

        if (memo[m] == 10001) System.out.println(-1);
        else System.out.println(memo[m]);
    }

    public static int getMinVal(int a, int b) {
        return a > b ? b : a;
    }
}
