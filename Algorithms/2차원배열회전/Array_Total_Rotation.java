class Array_Total_Rotation {

    public int[][] rotateClockwise(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int[][] newKey = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                newKey[j][col - 1 - i] = arr[i][j];
            }
        }

        return newKey;
    }
}
