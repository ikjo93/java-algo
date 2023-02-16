import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[] w, v;
    static Integer[][] bag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        w = new int[n];
        v = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        bag = new Integer[n][k + 1];

        System.out.println(pack(n - 1, k));
    }

    private static int pack(int i, int k) {
       if (i < 0) {
           return 0;
       }

       if (bag[i][k] == null) {
           if (w[i] > k) {
               bag[i][k] = pack(i - 1, k);
           } else {
               bag[i][k] = Math.max(pack(i - 1, k), pack(i - 1, k - w[i]) + v[i]);
           }
       }

       return bag[i][k];
    }
}
