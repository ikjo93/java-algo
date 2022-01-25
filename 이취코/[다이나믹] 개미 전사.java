import java.util.Scanner;

class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] foods = new int[n];
        int[] memo = new int[n];
        for (int i = 0; i < n; i++) {
            foods[i] = sc.nextInt();
        }

        memo[0] = foods[0];
        memo[1] = foods[1]; // !!

        for (int i = 2; i < n; i++) {
            memo[i] = getMaxVal(memo[i-1], memo[i-2] + foods[i]);
        }

        System.out.println(memo[n-1]);

    }

    public static int getMaxVal(int a, int b) {
        return a > b ? a : b;
    }

}
