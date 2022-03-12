import java.util.HashMap;

/*
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

 

示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

public class Leetcode_3 {
    public static void main(String[] args) {
        int abcabcbb = Solution_3.lengthOfLongestSubstring("abcabcbb");
        System.out.println(abcabcbb);
    }
}

class Solution_3 {
    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int result = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                start = Math.max(start, hashMap.get(s.charAt(i)) + 1);
            }
            hashMap.put(s.charAt(i), i);
            result = Math.max(result, i - start + 1);
        }
        return result;
    }
}