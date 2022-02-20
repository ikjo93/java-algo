import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {

    static int[][] miro;
    static int n, m;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        miro = new int[n][m];
        for (int i = 0; i < n; i++) {
            miro[i] = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(bfs(0, 0));
    }

    public static int bfs(int x, int y) {
        int nx, ny;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];

                if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1) continue;
                if (miro[nx][ny] == 0) continue;
                if (miro[nx][ny] == 1) {
                    miro[nx][ny] = miro[point.x][point.y] + 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }

        return miro[n-1][m-1];
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
