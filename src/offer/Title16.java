package offer;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 */
public class Title16 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(myPow(2, 3));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static double myPow(double x, int n) {
        if (x == 0) return 0;
        if (x == 1 || n == 0) return 1;
        double result = 1.0;
        if (n > 0) {
            while (n > 0) {
                // 3 ^ 4
                if (n % 2 == 0) {
                    x = x * x;
                    n = n / 2;
                }
                result = x * result;
                n--;
            }
        } else {
            while (n < 0) {
                if (n % 2 == 0) {
                    x = x * x;
                    n = n / 2;
                }
                result = 1 / x * result;
                n++;
            }
        }
        return result;
    }
}
