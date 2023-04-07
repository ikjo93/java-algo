import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    reference
     - 세그먼트 트리
       - https://www.acmicpc.net/blog/view/9
       - https://book.acmicpc.net/ds/segment-tree
       - https://steady-coding.tistory.com/124
     - 팬윅 트리
       - https://www.acmicpc.net/blog/view/21
       - https://yoongrammer.tistory.com/104
*/

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        long[] numbers = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            numbers[i] = Long.parseLong(br.readLine());
        }

        int treeHeight = (int) Math.ceil(Math.log(n) / Math.log(2));
        int treeSize = 1 << (treeHeight + 1);
        long[] tree = new long[treeSize];

        init(tree, numbers, 1, n, 1);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                long c = Long.parseLong(st.nextToken());
                long diff = c - numbers[b];
                numbers[b] = c;
                update(tree, 1, n, 1, b, diff);
            } else {
                int c = Integer.parseInt(st.nextToken());
                result.append(sum(tree, 1, n, 1, b, c)).append('\n');
            }
        }

        System.out.println(result);
    }

    private static long init(long[] tree, long[] numbers, int start, int end, int node) {
        if (start == end) {
            return tree[node] = numbers[start];
        }

        int mid = (start + end) / 2;

        return tree[node] = init(tree, numbers, start, mid, node * 2) + init(tree, numbers, mid + 1, end, node * 2 + 1);
    }

    private static void update(long[] tree, int start,
                               int end, int node, int idx, long diff) {
        if (idx < start || idx > end) {
            return;
        }

        tree[node] += diff;
        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;
        update(tree, start, mid, node * 2, idx, diff);
        update(tree, mid + 1, end, node * 2 + 1, idx, diff);
    }

    private static long sum(long[] tree, int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return sum(tree, start, mid, node * 2, left, right) + sum(tree, mid + 1, end, node * 2 + 1, left, right);
    }
}
