package leetcode;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 */
public class LeetCode_20 {

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}}"));
    }

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char item : chars) {
            if (item == ')' && !stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else if (item == ']' && !stack.empty() && stack.peek() == '['){
                stack.pop();
            } else if (item == '}' && !stack.empty() &&stack.peek() == '{') {
                stack.pop();
            } else {
                stack.push(item);
            }
        }
        return stack.empty();
    }
}
