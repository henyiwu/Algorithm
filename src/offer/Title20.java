package offer;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * <p>
 * 数值（按顺序）可以分成以下几个部分：
 * <p>
 * 若干空格
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 若干空格
 * 小数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * <p>
 * 部分数值列举如下：
 * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
 * <p>
 * 部分非数值列举如下：
 * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "0"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "e"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：s = "."
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：s = "     .1   "
 * 输出：true
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 20
 * s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。
 */
public class Title20 {

    public static void main(String[] args) {
        System.out.println(isNumber("      .1     "));
    }

    public static boolean isNumber(String s) {
        int n = s.length();
        int index = 0;
        boolean hasNum = false, hasE = false;
        boolean hasSign = false, hasDot = false;
        while (index < n && s.charAt(index) == ' ')
            index++;
        while (index < n) {
            while (index < n && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                index++;
                hasNum = true;
            }
            if (index == n) {
                break;
            }
            char c = s.charAt(index);
            // 当前是e或者E，如果已经有e或者前面没有数字，一定不是数字
            if (c == 'e' || c == 'E') {
                if (hasE || !hasNum) {
                    return false;
                }
                // e后面又是一个新的数字，重置变量
                hasE = true;
                hasNum = false;
                hasSign = false;
                hasDot = false;
            } else if (c == '+' || c == '-') {
                // 当前是+/-号，前面有符号、数字、小数点，一定不是数字
                if (hasSign || hasNum || hasDot) {
                    return false;
                }
                hasSign = true;
            } else if (c == '.') {
                if (hasDot || hasE) {
                    return false;
                }
                hasDot = true;
            } else if (c == ' ') {
                break;
            } else {
                return false;
            }
            index++;
        }
        // 定位到第一个不是空格的字符
        while (index < n && s.charAt(index) == ' ')
            index++;
        return hasNum && index == n;
    }
}
