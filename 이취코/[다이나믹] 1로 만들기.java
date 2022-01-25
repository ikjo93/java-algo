import java.util.Scanner;

class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] memo = new int[x+1];
        for (int i = 2; i <= x; i++) {
            memo[i] = memo[i-1] + 1;
            if (i % 2 == 0) memo[i] = getMinVal(memo[i], memo[i / 2] + 1);
            if (i % 3 == 0) memo[i] = getMinVal(memo[i], memo[i / 3] + 1);
            if (i % 5 == 0) memo[i] = getMinVal(memo[i], memo [i / 5] + 1);
        }
        System.out.println(memo[x]);
    }

    public static int getMinVal(int a, int b) {
        return a > b ? b : a;
    }

}
