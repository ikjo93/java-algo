import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if(i<=2) {
                list.add(i);
            } else if(i==3) {
                list.add(4);
            } else {
                list.add((list.get(i-2)+list.get(i-3)+list.get(i-4))%1000);
            }
        }

        System.out.println(list.get(n-1));

    }

}
