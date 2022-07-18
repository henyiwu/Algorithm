package offer;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix =[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 限制：
 * <p>
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 */
public class Title29 {
    public static void main(String[] args) {
        int[][] arr = {};
        spiralOrder(arr);
    }

    /**
     * 四个判断
     * 向右走到越界或者一个曾走过的数，一定向下走
     * 向下走到越界或者一个曾走过的数，一定向左走
     * 向左走到越界或者一个曾走过的数，一定向上走
     * 向上走到越界或者一个曾走过的数，一定向右走
     * 以此循环
     */
    public static int[] spiralOrder(int[][] matrix) {
        int direction = 4; // 1 2 3 4 上下左右
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        boolean[][] bArr = new boolean[matrix.length][matrix[0].length];
        int length = matrix.length * matrix[0].length;
        int[] result = new int[length];
        int row = 0;
        int column = 0;
        for (int i = 0; i < length; i++) {
            result[i] = matrix[row][column];
//            System.out.println("row " + row + ",, column " + column);
            if (direction == 4) { // 右
                if (column + 1 < matrix[0].length && !bArr[row][column + 1]) {
                    bArr[row][column] = true;
                    column++;
                } else {
                    direction = 2;
                    row++;
                }
                continue;
            }
            if (direction == 2) { // 下
                if (row + 1 < matrix.length && !bArr[row + 1][column]) {
                    bArr[row][column] = true;
                    row++;
                } else {
                    column--;
                    direction = 3;
                }
                continue;
            }
            if (direction == 3) { // 左
                if (column - 1 >= 0 && !bArr[row][column - 1]) {
                    bArr[row][column] = true;
                    column--;
                } else {
                    row--;
                    direction = 1;
                }
                continue;
            }
            if (direction == 1) { // 上
                if (row - 1 >= 0 && !bArr[row - 1][column]) {
                    bArr[row][column] = true;
                    row--;
                } else {
                    column++;
                    direction = 4;
                }
            }
        }
        return result;
    }
}
