package offer;

/**
 * 剑指 Offer 64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 * <p>
 * 输入: n = 9
 * 输出: 45
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 10000
 */
public class Title64 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumNums(3));
    }

    /**
     * 6 = (1+3) * 3 / 2
     * 45 = (1+9) * 9 / 2
     */
    static class Solution {
        public int sumNums(int n) {
            return (1 + n) * n / 2;
        }
    }
}
