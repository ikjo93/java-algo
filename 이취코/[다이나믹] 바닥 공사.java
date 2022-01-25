import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] memo = new int[1001];

        memo[1] = 1;
        memo[2] = 3;

        for (int i = 3; i <= n; i++) {
            memo[i] = (memo[i-1] + memo[i-2] * 2) % 796796;
        }

        System.out.println(memo[n]);
    }
}
