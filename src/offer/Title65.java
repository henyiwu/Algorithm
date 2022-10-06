package offer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * <p>
 * 示例:
 * <p>
 * 输入: a = 1, b = 1
 * 输出: 2
 *  
 * <p>
 * 提示：
 * <p>
 * a,b均可能是负数或 0
 * 结果不会溢出 32 位整数
 * <p>
 */
public class Title65 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.add(6, 7));
    }

    static class Solution {
        /**
         * 1. 与运算，左移一位，取得进位
         * 2. 循环，异或运算，获得结果
         */
        public int add(int a, int b) {
            while (b != 0) {
                int c = (a & b) << 1;  // c = 进位
                a ^= b; // a = 非进位和
                b = c; // b = 进位
            }
            return a;
        }
    }
}