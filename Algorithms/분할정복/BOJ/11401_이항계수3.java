import java.io.IOException;
import java.util.Scanner;

class Main {

    /**
     * 1 <= n <= 4,000,000 0 <= k <= n 일 때,
     *
     * ( n! / (k! * (n - k)!) ) mod 1,000,000,007 = ?
     *
     * 문제는 n이 최대 4,000,000으로 정수 오버플로우 발생
     *
     * 모듈러의 분배법칙을 이용하자!
     *
     * 하지만, 나눗셈에 대해선 모듈러의 분배 법칙 적용 X
     *
     * 어떤 수로 모듈러 나눗셈을 하고자 할 때는, 그 수의 곱셈에 대한 역원을 찾고 그 역원을 곱해주는 것으로 나눗셈을 대신 수행할 수 있다.
     *
     * 즉, ( n! / (k! * (n - k)!) ) mod 1,000,000,007 을 n! * (k! * (n - k)!)^(-1) mod 1,000,0007 로 나타낼 수 있다.
     *
     * 이때, (k! * (n - k)!)^(-1) mod 1,000,0007 는 페르마의 소정리를 통해 (k! * (n - k)!)^(1,000,0005) mod 1,000,0007 로 나타낼 수 있다.
     */

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();

        long[] factorials = new long[n + 1];
        factorials[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorials[i] = (factorials[i - 1] * i) % MOD;
        }

        System.out.println((factorials[n] * pow((factorials[k] * factorials[n - k]) % MOD, MOD - 2)) % MOD);
    }

    private static long pow(long base, long exp) {
        if (exp == 1) {
            return base;
        }

        long value = pow(base, exp / 2);

        if (exp % 2 == 1) {
            return (((value * value) % MOD) * base) % MOD;
        } else {
            return (value * value) % MOD;
        }
    }
}
