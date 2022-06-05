package offer;

public class Title10 {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int next = 0;
        for (int i = 3; i <= n; i++) {
            next = (a + b) % 1000000007;
            a = b;
            b = next;
        }
        return next;
    }
}