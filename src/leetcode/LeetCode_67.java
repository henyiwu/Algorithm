package leetcode;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */

public class LeetCode_67 {

    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int t = 0;
        int index1 = a.length()-1;
        int index2 = b.length()-1;
        while (index1 >= 0 || index2 >= 0 || t != 0) {
            if (index1 >= 0) {
                t = t + a.charAt(index1--) - '0';
            }
            if (index2 >= 0) {
                t = t + b.charAt(index2--) - '0';
            }
            stringBuilder.append(t%2);
            t = t / 2;
        }
        return String.valueOf(stringBuilder.reverse());
    }
}
