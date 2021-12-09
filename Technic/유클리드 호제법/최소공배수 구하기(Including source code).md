> # 유클리드 호제법을 이용한 최소공배수 구하기
> > ## 코드 설명
> > > 다음 메서드는 유클리드 호제법을 통해 최소공약수(gcd)를 먼저 구한 다음, 이를 통해 최대공배수(lcm)을 리턴하는 메서드입니다. 이때 무한한 수의 최대공약수와 최소공배수를 구하기 위해 BigInterger 자료형을 사용했습니다.
> > ## 소스 코드
> > > ```Java
> > > import java.math.BigInteger;
> > > import java.util.*;
> > > 
> > > public class Main {
> > > 
> > >     public static void main(String[] args) {
> > >         Scanner sc = new Scanner(System.in);
> > >         int a = sc.nextInt(), b = sc.nextInt();
> > >         System.out.printf("%d", lcm(a, b));
> > >     }
> > > 
> > >     public static BigInteger lcm(int a, int b){
> > >         BigInteger bigNumber1 = new BigInteger(String.valueOf(a));
> > >         BigInteger bigNumber2 = new BigInteger(String.valueOf(b));
> > > 
> > >         int n, gcd = 1;
> > >         if(a>b) {
> > >             while (b != 0) {
> > >                 n = a % b;
> > >                 a = b;
> > >                 b = n;
> > >             }
> > >             gcd = a;
> > >         } else {
> > >             while (a != 0) {
> > >                 n = b % a;
> > >                 b = a;
> > >                 a = n;
> > >             }
> > >             gcd = b;
> > >         }
> > > 
> > >         BigInteger bigNumber3 = new BigInteger(String.valueOf(gcd));
> > > 
> > >         return bigNumber1.multiply(bigNumber2).divide(bigNumber3);
> > >     }
> > > 
> > > }
> > > ```
