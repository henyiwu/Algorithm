package leetcode;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_70 {

    public int climbStairs(int n) {
        //f(1) = 1
        //f(2) = 2
        //f(3) = 3
        //f(4) = 5
        int a = 0, b = 1, result = 0;
        for (int i=0; i<n; i++) {
            result = a + b;
            a = b;
            b = result;
            // result = 1, a = 1, b = 1
            // result = 2, a = 1, b = 2
            // result = 3, a = 2, b = 3
        }
        return result;
    }
}
