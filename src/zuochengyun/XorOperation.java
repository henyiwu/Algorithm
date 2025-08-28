package zuochengyun;

import java.util.Arrays;

public class XorOperation {

    public static void main(String[] args) {
        int[] arr = {5, 5, 2, 1, 2, 3, 3, 4};
//        xorOperation1(arr);
        xorOperation2(arr);
    }

    /**
     * 一个整型数组中，有一种数出现了奇数次，其他数出现了偶数次，找出这个出现奇数次的数
     */
    private static void xorOperation1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        System.out.println("原数据:" + Arrays.toString(arr));
        int result = 0;
        for (int j : arr) {
            result = j ^ result;
        }
        System.out.println("结果数字: " + result);
    }


    /**gi
     * 一个整型数组中，有两种数出现了奇数次，其他数出现了偶数次，找出这个出现奇数次的数
     */
    private static void xorOperation2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 假设结果是a和b
        System.out.println("原数据:" + Arrays.toString(arr));
        int eor = 0;
        for (int k : arr) {
            eor = eor ^ k;
        }

        // 此时eor = a ^ bx

        // 因为两个数不同，所以他们的二进制一定有一位是不相同的，制造出最后一位是1其余都是0的数
        // 例如a和b分别是2和3
        // 2: 0010
        // 3: 0011
        // 制造出数 0010
        // 方式如下:eor & (~eor + 1)
        // 假设eor=1010
        // ~eor=0101
        // ~eor+1=0110
        // eor&(~eor+1)=1010&0110=0010
        int rightOne = eor & (~eor + 1);

        int result1 = 0;
        for (int j : arr) {
            if ((j & rightOne) == 0) {
                result1 = result1 ^ j;
            }
        }
        // 此时的leftOne一定是两个数中的其中一个

        int result2 = result1 ^ eor;

        System.out.println("结果数字: " + result1);
        System.out.println("结果数字: " + result2);
    }
}
