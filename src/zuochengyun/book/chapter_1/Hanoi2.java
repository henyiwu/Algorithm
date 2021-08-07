package zuochengyun.book.chapter_1;

/**
 * 出自《程序员代码面试指南》中的汉诺塔问题
 * 1. 采用非递归方式
 * 2. 圆盘不能直接从x移动到z，需要先x -> y -> z
 */
public class Hanoi2 {

    public static void main(String[] args) {
        System.out.println(hanoi(3, "x", "y", "z"));
    }

    public static int hanoi(int n, String left, String mid, String right) {
        if (n < 1) return 0;
        return process(n, left, mid, right, left, right);
    }

    private static int process(int num, String left, String mid, String right, String from, String to) {
        if (num == 1) {
            if (from.equals(mid) || to.equals(mid)) {
                System.out.println("Move 1 from " + from + " --> " + "to " + to);
                return 1;
            } else {
                System.out.println("Move 1 from " + from + " --> " + "to " + mid);
                System.out.println("Move 1 from " + mid + " --> " + "to " + to);
                return 2;
            }
        }
        if (from.equals(mid) || to.equals(mid)) {
            String another = (from.equals(left) || to.equals(left))? right : left;
            int part1 = process(num-1, left, mid, right, from, another);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + "to " + to);
            int part3 = process(num - 1, left, mid, right, another, to);
            return part1 + part2 + part3;
        } else {
            int part1 = process(num - 1, left, mid, right, from, to);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + mid);
            int part3 = process(num - 1, left, mid, right, to, from);
            int part4 = 1;
            System.out.println("Move " + num + " from " + mid + "to " + to);
            int part5 = process(num - 1, left, mid, right, from ,to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }

}
