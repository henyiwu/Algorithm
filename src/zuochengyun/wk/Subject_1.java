package zuochengyun.wk;

/**
 * Q1:一个整型数组中，有一种数出现了奇数次，其他数字都出现了偶数次，找出这个出现奇数次的数
 * 思路：取一个临时变量，遍历所有数并异或，得到的结果就是那个奇数个数的数字
 *
 * Q2:一个整形数组中，有两种数出现了奇数次，其他数字都出现了偶数次，找出这两个出现了奇数次的数
 */
public class Subject_1 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,2,2,3,3,3,5,5,4,4,6,6,6,6,7,7,7,17,17};
        printOddTimesNum2(arr);
    }

    /**
     * 问题1的解
     */
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int cur : arr) {
            eor = eor ^ cur;
        }
        System.out.println(eor);
    }

    /**
     * 问题2的解
     */
    public static void printOddTimesNum2(int[] arr) {
        // 假设要求的两个数分别为a和b
        int eor = 0;
        for (int j : arr) {
            eor ^= j;
        }
        // eor = a ^ b
        // eor & (~eor + 1), 取出最低位的数字1，其他都是0，例如1010 -> 0010
        int rightOne = eor & (~eor + 1);
        int onlyOne = 0;
        // 以rightOne为区分，将该位上是1和不是1的数分为两组
        for (int cur : arr) {
            if ((cur & rightOne) == 0) {
                onlyOne ^= cur;
            }
        }
        // 得到的onlyOne一定是a或者b，eor ^ onlyOne等于另一个数
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }
}
