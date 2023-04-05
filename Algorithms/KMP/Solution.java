import java.io.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {

            char[] target = br.readLine().toCharArray(); // 탐색 대상 문잦열
            char[] pattern = br.readLine().toCharArray(); // 찾고자 하는 문자열

            int n = target.length;
            int m = pattern.length;
            int[] pi = new int[m];

            int count = 0, idx = 0;

            for (int i = 1; i < m; i++) {
                while (idx > 0 && pattern[i] != pattern[idx]) {
                    idx = pi[idx - 1];
                }

                if (pattern[i] == pattern[idx]) {
                    idx++;
                    pi[i] = idx;
                }
            }

            idx = 0;
            for (int i = 0; i < n; i++) {
                while (idx > 0 && target[i] != pattern[idx]) {
                    idx = pi[idx - 1];
                }

                if (target[i] == pattern[idx]) {
                    if (idx == m - 1) {
                        count++;
                        idx = pi[idx];
                    } else {
                        idx++;
                    }
                }
            }

            result.append('#').append(testCase).append(' ').append(count).append('\n');
        }

        System.out.println(result);
    }
}
