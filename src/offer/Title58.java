package offer;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class Title58 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("a good   example"));
    }

    static class Solution {
        public String reverseWords(String s) {
            s = s.trim();
            String[] array = s.split(" ");
            String[] result = new String[array.length];
            int index = 0;
            for (int i = array.length - 1; i >= 0; i--) {
                result[index] = array[i];
                index++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < result.length; i++) {
                if (result[i].equals("") || result[i].equals(" ")) continue;
                stringBuilder.append(result[i]);
                if (i != result.length - 1) {
                    stringBuilder.append(" ");
                }
            }
            return stringBuilder.toString();
        }
    }
}
