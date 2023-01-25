package tsinghua.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * 快速排序的问题
 * 1. 递归
 * 2. 最坏情况
 *
 * 平均时间复杂度O(nlogN)
 * 最差时间复杂度O(N^2)
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {3, 4, 6, 2, 7, 1, 5};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int base = arr[start];
        while (i < j) {
            while (i < j && base <= arr[j]) { // 这里一定要<=，否则从左往右时左指针停在当前base
                j--;
            }
            while (i < j && base >= arr[i]) {
                i++;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        arr[start] = arr[i]; // 把ij重合的数，放到数组最左边
        arr[i] = base; // 把基数，放到ij重合的位置
        sort(arr, start, j - 1);
        sort(arr, j + 1, end);
    }
}
