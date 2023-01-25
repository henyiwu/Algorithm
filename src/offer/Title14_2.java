package offer;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class Title14_2 {

    public static void main(String[] args) {
        System.out.println(cuttingRope(120));
    }

    public static int cuttingRope(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        int a = n / 3;
        int b = n % 3;
        // 6 -> 3 * 3
        // 9 -> 3 * 3 * 3
        if (b == 0) {
            return (int) (pow(3, a) % 1000000007);
        }
        // 4 -> 4
        // 7 -> 4 * 3
        // 10 -> 4 * 3 * 3
        if (b == 1) {
            return (int) (4 * pow(3, a - 1) % 1000000007);
        }
        // 5 -> 2 * 3
        // 8 -> 2 * 3 * 3
        if (b == 2) {
            return (int) (2 * pow(3, a) % 1000000007);
        }
        return 0;
    }

    public static long pow(int num, int times) {
        long result = 1;
        for (int i = 0; i < times; i++) {
            result = result * num % 1000000007;
        }
        return result % 1000000007;
    }
}
