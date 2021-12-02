import java.util.*;

class Main {

    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), r = sc.nextInt();
        boolean[] visited = new boolean[n+2];
        visited[0] = true;
        visited[visited.length-1] = true;
        combination(visited, 1, n, r);
        System.out.print(cnt);
    }

    public static void combination(boolean[] visited, int start, int n, int r) {
        if(start+r-1>n) return;
        if(r == 0) {
            cnt++;
            return;
        }

        for(int i=start; i<=n; i++) {
            visited[i] = true;
            if(visited[i-1] == true) {
                combination(visited, i + 2, n, r - 1);
            }
            else {
                combination(visited, i + 1, n, r - 1);
            }
            visited[i] = false;
        }
    }

}
