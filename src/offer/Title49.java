package offer;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 * <p>
 * 1是丑数。
 * n不超过1690。
 * <p>
 */
public class Title49 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(10));
    }

    static class Solution {
        public int nthUglyNumber(int n) {
            // 构建2 3 5对应的左指针
            int p2 = 0;
            int p3 = 0;
            int p5 = 0;
            int[] dp = new int[n];
            dp[0] = 1;
            for (int i = 1; i < n; i++) {
                int a = dp[p2] * 2;
                int b = dp[p3] * 3;
                int c = dp[p5] * 5;
                dp[i] = Math.min(a, Math.min(b, c));
                if (a == dp[i]) p2++;
                if (b == dp[i]) p3++;
                if (c == dp[i]) p5++;
            }
            return dp[n - 1];
        }
    }
}
