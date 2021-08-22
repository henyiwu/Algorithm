package leetcode;

import java.util.HashMap;
import java.util.regex.Matcher;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LeetCode_3 {

    public static void main(String[] args) {
        int abcabcbb = lengthOfLongestSubstring("abcabcbb");
        System.out.println(abcabcbb);
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        // 往左边第一个与当前字符相同的数的位置
        int left = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                left = Math.max(left, hashMap.get(s.charAt(i))+1);
            }
            hashMap.put(s.charAt(i), i);
            max = Math.max(max, i-left+1);
        }
        return max;
    }
}

