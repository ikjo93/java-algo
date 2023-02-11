import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] number  = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        int[] memo = new int[n + 1];

        int result = 0;
        for (int i = 1; i <= n; i++) {
            memo[i] = 1;
            for (int j = 1; j < i; j++) {
                if (number[j] < number[i] && memo[i] <= memo[j]) {
                    memo[i] = memo[j] + 1;
                }
            }
            result = Math.max(result, memo[i]);
        }

        System.out.println(result);
    }
}
