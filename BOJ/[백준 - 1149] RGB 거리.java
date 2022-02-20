import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] rgbHouse = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                rgbHouse[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n - 1; i++) {
            int[] minValueAndIndex = getMinValueAndIndex(rgbHouse[i]);
            for (int j = 0; j < 3; j++) {
                if (minValueAndIndex[1] != j) {
                    rgbHouse[i + 1][j] += minValueAndIndex[0];
                }
                else {
                    Arrays.sort(rgbHouse[i]);
                    rgbHouse[i + 1][j] += rgbHouse[i][1];
                }
            }
        }

        System.out.println(getMinValueAndIndex(rgbHouse[n-1])[0]);
    }

    public static int[] getMinValueAndIndex(int[] arr) {
        int minValue = arr[0], index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (minValue > arr[i]) {
                minValue = arr[i];
                index = i;
            }
        }

        return new int[]{minValue, index};
    }
}
