import java.util.Arrays;
import java.util.Scanner;

class Main {

    static int[][] iceBoard;
    static int n, m;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        iceBoard = new int[n][m];
        for (int i = 0; i < n; i++) {
            iceBoard[i] = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) result++;
            }
        }

        System.out.println(result);
    }

    public static boolean dfs(int x, int y) {
        if (x < 0 || x > n - 1 || y < 0 || y > m - 1) {
            return false;
        }
        if (iceBoard[x][y] == 0) {
            iceBoard[x][y] = 1;
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }
}
