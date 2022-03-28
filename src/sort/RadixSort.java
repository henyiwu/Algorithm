package sort;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 6, 1, 3, 8};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    private static void radixSort(int[] arr, int L, int R, int digits) {
        final int radix = 10;
        int i = 0, j = 0;
        int[] bucket = new int[R - L + 1];
        // 入桶出桶几次，就有几次循环
        for (int d = 1; d <= digits; d++) {
            int[] count = new int[radix];
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = bucket[j];
            }
        }
    }

    /**
     * 最大数有几位，比如最大是100，返回3。最大是1000，返回4
     */
    private static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            max = Math.max(max, j);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    /**
     * 拿出这个位上的数字，比如13的个位是3，十位是1
     */
    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }
}
