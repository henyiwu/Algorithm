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

    public static void main(String[] args) {
        System.out.println(longestPalindrome2("abcba"));
    }

    /**
     * 动态规划
     */
    public static String longestPalindrome2(String s) {
        int maxLen = 1;
        int length = s.length();
        boolean[][] arr = new boolean[length][length];
        int start = 0;
        // 斜对角设置为true，因为1个字符必然是回文串
        for (int i = 0; i < length; i++) {
            arr[i][i] = true;
        }
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                // 头尾不相等
                if (s.charAt(i) != s.charAt(j)) {
                    arr[i][j] = false;
                } else {
                    // 字符串长度是1或2
                    if (j - i < 2) {
                        arr[i][j] = true;
                    } else {
                        // 掐头去尾
                        arr[i][j] = arr[i+1][j-1];
                    }
                }
                if (arr[i][j] && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
