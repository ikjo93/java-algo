import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            int o = Integer.parseInt(st.nextToken());
            switch (o) {
                case 1: {
                    upDown(arr);
                    break;
                }
                case 2: {
                    leftRight(arr);
                    break;
                }
                case 3: {
                    arr = rotateClockwise(arr);
                    break;
                }
                case 4: {
                    arr = rotateCounterClockwise(arr);
                    break;
                }
                case 5: {
                    rotateBlockClockwise(arr);
                    break;
                }
                default: {
                    rotateBlockCounterClockwise(arr);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int[] a : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                result.append(a[j]).append(' ');
            }
            result.append('\n');
        }
        System.out.println(result);
    }

    private static void upDown(int[][] arr) {
        int row = arr.length, col = arr[0].length;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row / 2; j++) {
                swap(arr, j, i, row - 1 - j, i);
            }
        }
    }

    private static void leftRight(int[][] arr) {
        int row = arr.length, col = arr[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col / 2; j++) {
                swap(arr, i, j, i, col - 1 - j);
            }
        }
    }

    private static int[][] rotateClockwise(int[][] arr) {
        int row = arr[0].length;
        int col = arr.length;
        int[][] newArr = new int[row][col];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                newArr[j][col - 1 - i] = arr[i][j];
            }
        }

        return newArr;
    }

    private static int[][] rotateCounterClockwise(int[][] arr) {
        int row = arr[0].length;
        int col = arr.length;
        int[][] newKey = new int[row][col];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                newKey[row - 1 - j][i] = arr[i][j];
            }
        }

        return newKey;
    }

    private static void rotateBlockClockwise(int[][] arr) {
        int midRow = arr.length / 2, midCol = arr[0].length / 2;
        for (int i = 0; i < midRow; i++) {
            for (int j = 0; j < midCol; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[midRow + i][j];
                arr[midRow + i][j] = arr[midRow + i][midCol + j];
                arr[midRow + i][midCol + j] = arr[i][midCol + j];
                arr[i][midCol + j] = temp;
            }
        }
    }

    private static void rotateBlockCounterClockwise(int[][] arr) {
        int midRow = arr.length / 2, midCol = arr[0].length / 2;
        for (int i = 0; i < midRow; i++) {
            for (int j = 0; j < midCol; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][midCol + j];
                arr[i][midCol + j] = arr[midRow + i][midCol + j];
                arr[midRow + i][midCol + j] = arr[midRow + i][j];
                arr[midRow + i][j] = temp;
            }
        }
    }

    private static void swap(int[][] arr, int x1, int y1, int x2, int y2) {
        int temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }
}
