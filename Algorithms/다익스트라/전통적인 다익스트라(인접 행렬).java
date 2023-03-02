import java.io.*;
import java.util.*;

/*

5
0 4
0 2 2 5 9
2 0 3 4 8
2 3 0 7 6
5 4 7 0 5
9 8 6 5 0

정답 : 8

6
5 4
0 3 5 0 0 0
0 0 2 6 0 0
0 1 0 4 6 0
0 0 0 0 2 3
3 0 0 0 0 6
0 0 0 0 0 0

정답 : -1

*/

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[][] adjMatrix = new int[v][v];
        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < v; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        final int INF = Integer.MAX_VALUE;
        int[] distance = new int[v]; // 출발 정점에서 자신까지 오는 최소 비용
        boolean[] visited = new boolean[v]; // 경유지로 고려된 정점 여부

        Arrays.fill(distance, INF); // 최소값 갱신 로직을 반영해야하므로 큰 값으로 초기화
        distance[start] = 0;

        int min, current;
        for (int i = 0; i < v; i++) {
            // step1 : 경유지로 처리되지 않은 정점 중 출발지에서 가장 가까운 정점 선택
            current = -1;
            min = INF;
            for (int j = 0; j < v; j++) {
                if (!visited[j] && min > distance[j]) {
                    min = distance[j];
                    current = j;
                }
            }

            if (current == -1) {
                break;
            }

            visited[current] = true;

            // 선택된 정점이 문제에서 요구하는 도착 정점이면 끝내기
            if (current == end) break;

            // step2 : 위에서 선택된 정점을 경유지로 해서 갈 수 있는 다른 미방문 인접 정점과의 비용 최소값 갱신
            for (int j = 0; j < v; j++) {
                // !visited[j] 생략 가능 -> distance[j] 가 항상 min + adjMatrix[current][j] 보다 작음
                if (!visited[j] && adjMatrix[current][j] != 0
                    && distance[j] > min + adjMatrix[current][j]) {
                    distance[j] = min + adjMatrix[current][j];
                }
            }
        }

        System.out.println(distance[end] == INF ? -1 : distance[end]);
    }
}
