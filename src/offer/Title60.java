package offer;

import java.util.Arrays;
import java.util.HashMap;

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
        double[] doubles = solution.dicesProbability(3);
        System.out.println();
    }

    static class Solution {
        public double[] dicesProbability(int n) {
            int[][] dp = new int[n + 1][n * 6 + 1];
            for (int i = 1; i <= 6; i++) {
                dp[1][i] = 1;
            }
            for (int i = 2; i <= n; i++) {
                for (int j = i; j <= 6 * i; j++) {
                    System.out.println("-----------");
                    for (int k = 1; k <= 6; k++) {
                        if (j < k) break;
                        System.out.println("dp[" + i + "][" + j + "] += dp[" + (i - 1) + "][" + (j - k) + "]");
                        dp[i][j] += dp[i - 1][j - k];
                    }
                    System.out.println("-----------");
                }
            }

            double[] res = new double[5 * n + 1];
            int index = 0;
            double sum = Math.pow(6, n);
            for (int i = n; i <= 6 * n; i++) {
                res[index++] = dp[n][i] / sum;
            }
            return res;
        }
    }
}