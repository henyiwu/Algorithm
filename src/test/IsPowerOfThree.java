package test;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 */
public class IsPowerOfThree {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfThree(45));
    }

    static class Solution {
        public boolean isPowerOfThree(int n) {
            if (n <= 0) {
                return false;
            }
            while (n >= 3) {
                if (n % 3 != 0) {
                    return false;
                }
                n = n / 3;
            }
            if (n == 1) {
                return true;
            } else {
                return false;
            }
        }
    }
}
