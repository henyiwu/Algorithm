package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 */
public class LeetCode_22 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }

    public static List<String> res;

    public static List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs(n, 0, 0, "");
        return res;
    }

    /**
     * @param n    括号一共多少个
     * @param lc   左括号用了多少个
     * @param rc   右括号用了多少个
     * @param path 当前得到的结果
     */
    private static void dfs(int n, int lc, int rc, String path) {
        if (lc == n && rc == n) {
            res.add(path);
        } else {
            if (lc < n) dfs(n, lc + 1, rc, path + '(');
            if (rc < n && lc > rc) dfs(n, lc, rc + 1, path + ')');
        }
    }
}
