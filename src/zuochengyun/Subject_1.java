package zuochengyun;

/**
 * 一个整型数组中，有一种数出现了偶数次，另一种数出现了奇数次，找出这个出现奇数次的数
 * 思路：取一个临时变量，遍历所有数并异或，得到的结果就是那个奇数个数的数字
 */
public class Subject_1 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,2,2,3,3,4,4,6,6,6,6,7,7,7,17,17};
        printOddTimesNum1(arr);
    }

    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int cur : arr) {
            eor = eor ^ cur;
        }
        System.out.println(eor);
    }
}
