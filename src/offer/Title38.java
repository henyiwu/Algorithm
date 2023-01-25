package offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
剑指 Offer 38. 字符串的排列
输入一个字符串，打印出该字符串中字符的所有排列。

你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

示例:

输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]

限制：

1 <= s 的长度 <= 8
 */
public class Title38 {

    static class Solution {
        public String[] permutation(String s) {
            HashSet<String> hashSet = new HashSet<>();
            char[] chars = s.toCharArray();
            boolean[] booleans = new boolean[chars.length];
            recur(hashSet, "", chars, booleans);
            return hashSet.toArray(new String[0]);
        }

        private void recur(Set<String> hashSets, String s, char[] chars, boolean[] b) {
            if (chars.length == s.length()) {
                hashSets.add(s);
                return;
            }
            for (int i = 0; i < chars.length; i++) {
                if (b[i]) {
                    continue;
                }
                b[i] = true;
                recur(hashSets, s + chars[i], chars, b);
                b[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.permutation("abc")));
    }
}
