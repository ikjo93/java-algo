import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);
        int[] tteoks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int start = 0, end = max(tteoks), result = 0, mid, target;
        while(start <= end) {
            target = 0;
            mid = (start + end) / 2;

            for(int tteok : tteoks)
                if(tteok > mid) target += (tteok - mid);

            if(target >= M) {
                result = mid;
                start = mid + 1;
            }
            else end = mid - 1;
        }
        System.out.println(result);
    }

    public static int max(int n[]) {
        int max = n[0];

        for (int i = 1; i < n.length; i++)
            if (n[i] > max) max = n[i];

        return max;
    }
}
