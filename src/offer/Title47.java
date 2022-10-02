package offer;

/**
 * 中等
 * 剑指 Offer 47. 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * 示例 1:
 * 输入:
 * [[1,3,1],
 * [1,5,1],
 * [4,2,1]]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * <p>
 * 提示：
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 */
public class Title47 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        solution.maxValue(arr);
    }

    static class Solution {
        public int maxValue(int[][] grid) {
            // 数组大小为0，直接返回
            if (grid.length == 0) return 0;

            // 1. 创建一个与原数组数量相同的新数组
            // 2. 这个新数组存的是：按照规则，走到arr[i][j]时，最大的值
            // 比如题目中的数组可以组成:
            // [[1,4,5],
            //  [2,9,10],
            //  [6,11,12]]
            int[][] resultArr = new int[grid.length][grid[0].length];
            for (int i = 0; i < resultArr.length; i++) {
                for (int j = 0; j < resultArr[0].length; j++) {
                    if (i == 0 && j == 0) {
                        resultArr[i][j] = grid[0][0];
                    } else {
                        if (j == 0) { // 最左边第一列，只能取它上面的数
                            resultArr[i][j] = grid[i][j] + resultArr[i - 1][j];
                        } else if (i == 0) { // 最上面一行，只能取它左边的数
                            resultArr[i][j] = grid[i][j] + resultArr[i][j - 1];
                        } else {
                            if (resultArr[i][j - 1] > resultArr[i - 1][j]) {
                                resultArr[i][j] = resultArr[i][j - 1] + grid[i][j];
                            } else {
                                resultArr[i][j] = resultArr[i - 1][j] + grid[i][j];
                            }
                        }
                    }
                }
            }

            int row = grid.length;
            int column = grid[0].length;
            return resultArr[row - 1][column - 1];
        }
    }
}
