package leetcode;

/**
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * 回文串：正读反读都一样的字符串
 */

public class LeetCode_5 {
    public boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 暴力解法
    // O(N2) 时间超出限制
    public String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isPalindromic(test) && test.length() > max) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        return ans;
    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        //最大长度
        int maxLen = 1;
        int begin = 0;
        //存储是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] chars = s.toCharArray();
        // 单个字符一定是回文
        // 填充二维数组的斜对角线
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        // 循环斜对角的右上方部分
        // i : 从第i个开始
        // j : 从第j个开始
        // dp[i][j] : 从i到j的子串是否是回文数
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) { // 首尾字符不想等，一定不是回文串
                    dp[i][j] = false;
                } else {
                    //长度为2或3是，肯定是回文。即除去chars[i]和 chars[j]后，只要1个或0个字符。防止出现例如 i=2 j=3情况下 查看dp[3][2]。
                    if (j - i < 2) {
                        dp[i][j] = true;
                    } else {
                        //排除头尾元素后，是否是回文串
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 当前字符串是回文串，且长度比最大长度大
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, maxLen + begin);
    }
}
