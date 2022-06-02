package zuochengyun.book.chapter_1;

import org.openjdk.jol.info.ClassLayout;

public class Hanoi {
    public static void main(String[] args) {
        System.out.println(hanoi(4, "x", "y", "z"));

        System.out.println(ClassLayout.parseInstance(new Object()).toPrintable());
    }

    public static int hanoi(int n, String from, String mid, String to) {
        if (n < 1) {
            return 0;
        }
        return process(n, from, mid, to);
    }

    public static int process(int n, String from, String mid, String to) {
        if (n == 1) {
            System.out.println(from + " -> " + to);
            return 1;
        } else {
            int part1 = process(n - 1, from, to, mid); //  把n-1个圆环由z辅助，从x移动到y
            int part2 = 1;
            System.out.println(from + " -> " + to); // 只剩下一个圆环，从x移动到z
            int part3 = process(n - 1, mid, from, to); // 把n-1个圆环由x辅助，从y移动到z
            return part1 + part2 + part3;
        }
    }
}
