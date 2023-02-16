import java.io.*;
import java.util.StringTokenizer;

/**
 * reference : https://train-validation-test.tistory.com/entry/%EB%B0%B1%EC%A4%80-10653-%EB%B2%88-Gold-V-%EB%A7%88%EB%9D%BC%ED%86%A42-Solved-By-Ja
 */

class Main {

    static int n, k;
    static int[][] distances, memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());

        /*
             체크포인트별 좌표(x, y) 기록
         */
        int[][] positions = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            positions[i][0] = Integer.parseInt(st.nextToken());
            positions[i][1] = Integer.parseInt(st.nextToken());
        }

        /*
            모든 인접한 체크포인트간 거리를 구함
            1 -> 2
            1 -> 3
              ...
            1 -> n
            2 -> 3
            2 -> 4
              ...
            n - 1 -> n
         */
        distances = new int[n + 1][n + 1];
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                distances[i][j] = Math.abs(positions[i][0] - positions[j][0]) +
                        Math.abs(positions[i][1] - positions[j][1]);
            }
        }

        /*
            메모이제이션되는 값의 의미
             - 1 ~ n개의 체크포인트를 방문할 때, 최대 k 개를 건너 뛸 때 갈 수 있는 최소 거리
         */
        memo = new int[n + 1][k + 1];

        System.out.println(check(n, k));
    }

    private static int check(int n, int k) {
        // memo[n][k]가 0이 아니라면, 이미 최소값 산출 작업(아래 반복문)이 끝난 것이므로 그 값 그대로 return
        if (memo[n][k] != 0) {
            return memo[n][k];
        }

        // n = 1 즉, 시작점에서는 건너 뛸 수 있는 게 없음
        if (n == 1) {
            return 0;
        }

        memo[n][k] = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) { // i = 0 : 건너뛰지 않는 것, i = 1 : 한 개 건너 뛰는 것, ...
            if (n - i - 1 > 0) {
                memo[n][k] = Math.min(
                        /*
                            check(n - i - 1, k - i) 의 의미란?
                            >> i = 0인 경우(건너뛰는 게 없는 경우)
                               n - 1 개의 체크포인트를 최대 k 개 건너 뛰었을 때 갈 수 있는 최소 거리 구하기
                            >> i = 1인 경우(1개 건너 뛰는 경우)
                               n - 2 개의 체크포인트를 최대 k - 1 개 건너 뛰었을 때 갈 수 있는 최소 거리 구하기

                            distances[n - i - 1][n] 의 의미란?
                            >> i = 0인 경우(건너뛰는 게 없는 경우)
                               n - 1에서 n 까지의 거리
                            >> i = 1인 경우(1개 건너 뛰는 경우)
                               n - 2에서 n 까지의 거리
                         */
                        check(n - i - 1, k - i) + distances[n - i - 1][n],
                        memo[n][k]
                );
            }
        }

        return memo[n][k];
    }
}
