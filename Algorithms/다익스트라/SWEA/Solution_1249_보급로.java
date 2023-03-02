import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder result = new StringBuilder();
    static int n, INF = 10_000;
    static int START_POINT_X = 0, START_POINT_Y = 0;
    static int[][] board, times;
    static final int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            test(testCase);
        }

        System.out.println(result);
        br.close();
    }

    private static void test(int testCase) throws IOException {
        result.append('#').append(testCase).append(' ');

        n = Integer.parseInt(br.readLine());
        initBoard();

        dijkstra(START_POINT_X, START_POINT_Y);

        result.append(times[n - 1][n - 1]).append('\n');
    }

    private static void initBoard() throws IOException {
        board = new int[n][n];
        times = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j) - 48;
                times[i][j] = INF;
            }
        }
    }

    private static void dijkstra(int x, int y) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o[2])));
        pq.add(new int[]{x, y, 0});
        times[x][y] = 0;

        int nx, ny, cost;
        while (!pq.isEmpty()) {
            int[] pos = pq.poll();

            if (times[pos[0]][pos[1]] < pos[2]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                nx = pos[0] + dx[i];
                ny = pos[1] + dy[i];

                if (nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1) {
                    continue;
                }

                cost = times[pos[0]][pos[1]] + board[nx][ny];
                if (cost < times[nx][ny]) {
                    times[nx][ny] = cost;
                    pq.add(new int[]{nx, ny, cost});
                }
            }
        }
    }
}
