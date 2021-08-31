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

}

/**
 * 动态规划
 */
class Solution2 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len <= 1)
            return s;
        boolean[][] flag =  new boolean[len][len];
        int start = 0;    //回文串起始位置
        int maxLen = 0;   //回文串最大长度
        // 子串长度为1和为2的初始化
        for(int i = 0; i < len; i++){
            flag[i][i] = true;
            if(i < len-1 && s.charAt(i) == s.charAt(i+1)){
                flag[i][i+1] = true;
                start = i;
                maxLen = 2 ;
            }
        }
        //m代表回文子串长度，从3开始
        for(int m = 3; m <= len; m++){
            for(int i = 0; i <= len-m; i++){
                int j = i+m-1;    // 子串结束的位置
                if(flag[i+1][j-1] && s.charAt(i)== s.charAt(j)){
                    flag[i][j] = true;
                    start = i;
                    maxLen = m;
                }
            }
        }
        if(start == 0 && maxLen == 0)
            return String.valueOf(s.charAt(0));
        return s.substring(start, start + maxLen);
    }

}