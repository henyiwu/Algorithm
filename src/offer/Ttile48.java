package offer;

import com.oracle.tools.packager.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * 中等
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Ttile48 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("eafafe"));
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> hashMap = new HashMap<>();
            int result = 0;
            int location = -1;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                // 遇到重复的字符，更新左指针
                if (hashMap.containsKey(c)) {
                    System.out.println("i : " + i + "location : " + location + ",, hashMap.get(c) : " + hashMap.get(c));
                    location = Math.max(location, hashMap.get(c));
                }
                hashMap.put(c, i);
                result = Math.max(result, i - location);
            }
            return result;
        }
    }
}
