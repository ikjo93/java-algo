public class Array_Partial_Rotation {

    public static void rotate(int[][] arr, int rowStart, int colStart, int rowEnd, int colEnd) {
        int temp = arr[rowStart][colStart];

        // left
        for (int i = rowStart; i < rowEnd; i++) {
            arr[i][colStart] = arr[i + 1][colStart];
        }

        // bottom
        for (int i = colStart; i < colEnd; i++) {
            arr[rowEnd][i] = arr[rowEnd][i + 1];
        }

        // right
        for (int i = rowEnd; i > rowStart; i--) {
            arr[i][colEnd] = arr[i - 1][colEnd];
        }

        // top
        for (int i = colEnd; i > colStart; i--) {
            arr[rowStart][i] = arr[rowStart][i - 1];
        }

        arr[rowStart][colStart + 1] = temp;
    }

    public static void reverseRotate(int[][] arr, int rowStart, int colStart, int rowEnd, int colEnd) {
        int temp = arr[rowEnd][colStart];

        // left
        for (int i = rowEnd; i > rowStart; i--) {
            arr[i][colStart] = arr[i - 1][colStart];
        }

        // top
        for (int i = colStart; i < colEnd; i++) {
            arr[rowStart][i] = arr[rowStart][i + 1];
        }

        // right
        for (int i = rowStart; i < rowEnd; i++) {
            arr[i][colEnd] = arr[i + 1][colEnd];
        }

        // bottom
        for (int i = colEnd; i > colStart; i--) {
            arr[rowEnd][i] = arr[rowEnd][i - 1];
        }

        arr[rowEnd][colStart + 1] = temp;
    }
}
