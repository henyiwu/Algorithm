package offer;

/**
 * 剑指 Offer 60. n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * <p>
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例 2:
 * <p>
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 11
 */
public class Title60 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        double[] doubles = solution.dicesProbability(2);
        System.out.println();
    }

    static class Solution {
        public double[] dicesProbability(int n) {
            // 1. 把一个骰子所有面出现的个数，记录在二维数组中
            int[][] arr = new int[n][n * 6];
            for (int i = 0; i < 6; i++) {
                arr[0][i] = 1;
            }

            // 2. 填满二维数组，arr[i][j]表示，i+1个骰子，出现j+1点数的次数是多少
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n * 6; j++) {
                    for (int k = 0; k < 6; k++) {
                        if ((j - k - 1) < 0) {
                            break;
                        }
                        arr[i][j] = arr[i][j] + arr[i - 1][j - k - 1];
                    }
                }
            }

            // 3.创建结果数组，将点数转换成概率
            double[] result = new double[n * 6 - (n - 1)];
            int index = 0;
            for (int i = 0; i < arr[n - 1].length; i++) {
                if (arr[n - 1][i] == 0) {
                    continue;
                }
                result[index++] = arr[n - 1][i] / Math.pow(6, n);
            }

            return result;
        }
    }
}