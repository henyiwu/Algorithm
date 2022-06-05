package offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 青蛙跳台阶相当于斐波那契数列问题，每格台阶的跳法都可以看成它上一级和上上级台阶的跳法之和
 */
public class Title10_1 {

    public static void main(String[] args) {

    }

    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int next = 0;
        for (int i = 3; i <= n; i++) {
            next = (a + b) % 1000000007;
            a = b;
            b = next;
        }
        return next;
    }
}
