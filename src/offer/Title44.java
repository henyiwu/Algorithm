package offer;

/*
剑指 Offer 44. 数字序列中某一位的数字
数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。

请写一个函数，求任意第n位对应的数字。

示例 1：

输入：n = 3
输出：3

示例 2：
输入：n = 11
输出：0

限制：

0 <= n < 2^31
 */
public class Title44 {

    // 1 2 3 4 5 6 7 8 9 10 11 12 13 14
//    static class Solution {
//        /**
//         * 超时
//         * 逻辑：遍历，计算出当前数是几位数，每次跳过这么多位，定位出目标落在哪个数的第几位上
//         */
//        public int findNthDigit(int n) {
//            int[] num = num(n);
//            int param1 = num[0]; // 落在哪数上
//            int param2 = num[1]; // 这个数的第几位
//            String str = String.valueOf(param1);
//            char[] chars = str.toCharArray();
//            char aChar = chars[param2];
//            return aChar - '0';
//        }
//
//        /**
//         * 落在哪个数字上
//         */
//        public int[] num(int n) {
//            int[] result = new int[2];
//            int loop = n;
//            for (int i = 1; i <= loop; i++) {
//                n = n - bit(i);
//                if (n <= 0) {
//                    result[0] = i;
//                    result[1] = Math.abs(n);
//                    result[1] = bit(i) - result[1] - 1;
//                    return result;
//                }
//            }
//            return result;
//        }
//
//        /**
//         * 位数
//         */
//        public int bit(int n) {
//            int result = 0;
//            while (n > 0) {
//                n = n / 10;
//                result++;
//            }
//            return result;
//        }
//    }

    static class Solution {
        public int findNthDigit(int n) {
            int bit = 1;
            long start = 1;
            long count = 9;
            while (n > count) {
                n = (int) (n - count);
                bit++;
                start = start * 10;
                count = start * 9 * bit;
            }
            long num = start + (n - 1) / bit;
            int index = (n - 1) % bit;
            return Long.toString(num).charAt(index) - '0';
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14
        System.out.println(solution.findNthDigit(12));
    }
}
