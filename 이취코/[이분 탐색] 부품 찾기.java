import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] parts = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(br.readLine());
        int[] estimates = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(parts);

        for (int i = 0; i < estimates.length; i++) {
            int start = 0, end = parts.length, target = estimates[i], mid;
            String result = "no";
            while(start<=end){
                mid = (start + end) / 2;
                if(target == parts[mid]){
                    result = "yes";
                    break;
                }
                else if(target > parts[mid]) start = mid + 1;
                else end = mid - 1;
            }
            System.out.printf("%s ", result);
        }
    }
}
