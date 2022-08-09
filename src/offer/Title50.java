package offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * 示例 2:
 * <p>
 * 输入：s = ""
 * 输出：' '
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 50000
 */
public class Title50 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char abaccdeff = solution.firstUniqChar("abaccdeff");
        System.out.println(abaccdeff);
    }

    static class Solution {
        public char firstUniqChar(String s) {
            HashMap<Character, Integer> hashMap = new HashMap<>();
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                Integer integer = hashMap.get(aChar);
                if (integer == null) {
                    integer = 0;
                }
                integer++;
                hashMap.put(aChar, integer);
            }

            for (char aChar : chars) {
                Integer integer = hashMap.get(aChar);
                if (integer == 1) {
                    return aChar;
                }
            }
            return ' ';
        }
    }
}