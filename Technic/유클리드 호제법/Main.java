import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        System.out.printf("%d", lcm(a, b));
    }

    public static BigInteger lcm(int a, int b){
        BigInteger bigNumber1 = new BigInteger(String.valueOf(a));
        BigInteger bigNumber2 = new BigInteger(String.valueOf(b));

        int n, gcd = 1;
        if(a>b) {
            while (b != 0) {
                n = a % b;
                a = b;
                b = n;
            }
            gcd = a;
        } else {
            while (a != 0) {
                n = b % a;
                b = a;
                a = n;
            }
            gcd = b;
        }

        BigInteger bigNumber3 = new BigInteger(String.valueOf(gcd));

        return bigNumber1.multiply(bigNumber2).divide(bigNumber3);
    }

}
