import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    /**
     * a * b^(-1) (MOD X) = a * b^(X - 2) (MOD X)
     *
     * (example)
     * Q = 7/3을 7 * 3^(-1) (MOD X)로 표현해보자!
     *
     * 이때, 1/3 = 3^(-1)은 3의 모듈러 곱셈에 대한 역원이므로,
     * 3^(-1) * 3 ≡ 1 (MOD 11) 을 만족한다. (X는 임의로 11로 정함)
     * 
     * 참고로 페르마의 소정리에 의해 b^(X - 1) ≡ 1 (MOD X)를 만족하며,  
     * 이는 다시 b^(X - 2) ≡ b^(-1) (MOD X)를 만족한다. 
     * 
     * 따라서, 3^(10) ≡ 1 (MOD 11)를 만족하며,
     * 3^(9) ≡ 3^(-1) (MOD 11)를 만족한다.
     * 
     * 결론적으로 7 * 3^(-1) (MOD X) 식을 7 * 3^(9) (MOD 11) 식으로 대신할 수 있다. (X는 임의로 11로 정함)
     *
     * (참고)
     * Q = 7/3 ≡ 7 * 3^(-1) (MOD 11) ≡ 7 * 3^(9) (MOD 11) ≡ 7 * 4 (MOD 11) ≡ 6 (MOD 11)
     */

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());

        long result = 0;
        StringTokenizer st;
        int a, b, gcd;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            b = Integer.parseInt(st.nextToken()); a = Integer.parseInt(st.nextToken());
            gcd = gcd(a, b);
            a /= gcd; b /= gcd;
            result += a * pow(b, MOD - 2) % MOD;
        }

        System.out.println(result % MOD);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    private static long pow(int base, int exp) {
        if (exp == 1) {
            return base;
        }

        long value = pow(base, exp / 2);

        if (exp % 2 == 1) {
            return ((value * value) % MOD) * base % MOD;
        } else {
            return value * value % MOD;
        }
    }
}
