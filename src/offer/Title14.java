package offer;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class Title14 {

    public static void main(String[] args) {
        System.out.println(cuttingRope(5));
    }

    public static int cuttingRope(int n) {
        // 长度为n的绳子，最大的乘积是多少
        int[] dp = new int[n + 1];
        // 长度为2的绳子，剪出来只能是1*1=1
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        // i表示绳子长度，因为计算n的长度，可以看成子问题的和，所以要计算比n小的绳子的长度
        // 外循环：长度为i的绳子
        // 内循环：长度为i的绳子剪成段
        for (int i = 3; i < n + 1; i++) {
            for (int j = 2; j < i; j++) {
                // param1:剪掉长度j，剩下的不剪
                int param1 = j * (i - j);
                // param2:剪掉长度j，剩下的也剪
                int param2 = j * dp[i - j];
                int curMax = Math.max(param1, param2);
                dp[i] = Math.max(dp[i], curMax);
            }
        }
        return dp[n];
    }
}
