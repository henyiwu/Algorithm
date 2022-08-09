package offer;

import java.util.ArrayList;

/*
剑指 Offer 46. 把数字翻译成字符串
给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

示例 1:

输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"

提示：

0 <= num < 231
 */
public class Title46 {

    static class Solution {
        /**
         * 动态规划
         * 判断当前数与前一个数组合，能不能在10-25的范围，如果不能，说明只能翻译自己
         * 如果可以，则当前数可以翻译的次数，等于它前两个数可翻译次数相加
         */
        public int translateNum(int num) {
            String str = String.valueOf(num);
            int[] result = new int[str.length() + 1];
            result[0] = 1;
            result[1] = 1;
            for (int i = 2; i < result.length; i++) {
                String temp = str.substring(i - 2, i);
                int n = Integer.parseInt(temp);
                if (n >= 10 && n <= 25) {
                    result[i] = result[i - 1] + result[i - 2];
                } else {
                    result[i] = result[i - 1];
                }
            }
            return result[result.length - 1];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.translateNum(121222));
    }
}
