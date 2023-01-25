package tsinghua;

/**
 * 汉诺塔（Tower of tsinghua.Hanoi），又称河内塔，是一个源于印度古老传说的益智玩具。
 * 大梵天创造世界的时候做了三根金刚石柱子，在一根柱子上从下往上按照大小顺序摞着64片黄金圆盘。
 * 大梵天命令婆罗门把圆盘从下面开始按大小顺序重新摆放在另一根柱子上。
 * 并且规定，在小圆盘上不能放大圆盘，在三根柱子之间一次只能移动一个圆盘。
 * <p>
 * 解题思路：
 * 1. 把第n-1个盘子从A经过C移动到B
 * 2. 把第n个圆盘从A移动到C
 * 3. 把第n-1个小圆盘从B经过A移动到C
 */

public class Hanoi {

    public static void main(String[] args) {
        hanoi(3, 'a', 'b', 'c');
    }

    /**
     * 把n个盘子，从a经过b移动到c
     *
     * n = 1
     *把盘子从a移动到c // 把最大的盘子，从a移动到c
     *
     * n = 2
     * 把盘子从a移动到b
     * 把盘子从a移动到c // 把最大的盘子，从a移动到c
     * 把盘子从b移动到c
     *
     * n = 3
     * 把盘子从a移动到c
     * 把盘子从a移动到b
     * 把盘子从c移动到b
     * 把盘子从a移动到c // 把最大的盘子，从a移动到c
     * 把盘子从b移动到a
     * 把盘子从b移动到c
     * 把盘子从a移动到c
     */
    public static void hanoi(int n, char a, char b, char c) {
        if (n > 0) {
            hanoi(n - 1, a, c, b);
            System.out.println("把盘子从" + a + "移动到" + c);
            hanoi(n - 1, b, a, c);
        }
    }
}
