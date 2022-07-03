package offer;

public class Title14 {

    public static void main(String[] args) {
        System.out.println(cuttingRope(5));
    }

    public static int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        // 长度为2的绳子，剪出来只能是1*1=1
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        // i表示绳子长度，因为计算n的长度，可以看成子问题的和，所以要计算比n小的绳子的长度
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
