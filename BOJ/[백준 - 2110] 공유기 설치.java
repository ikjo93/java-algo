import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static int[] houses;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());

        houses = new int[N];

        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int start = 1, end = houses[N-1] - houses[0], mid;

        while (start <= end) {
            mid = (start + end) / 2;

            if (cntRouters(mid) < C) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        System.out.println(start - 1);

    }

    public static int cntRouters(int mid) {

        int count = 1, lastRouter = houses[0], presentRouter;

        for (int i = 1; i < houses.length; i++) {
            presentRouter = houses[i];

            if(presentRouter - lastRouter >= mid) {
                count++;
                lastRouter = presentRouter;
            }

        }

        return count;
    }

}

// 참고 자료 : https://st-lab.tistory.com/277
