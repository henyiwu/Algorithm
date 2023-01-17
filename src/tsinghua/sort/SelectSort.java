package tsinghua.sort;

import java.util.Arrays;

/**
 * 选择排序
 * <p>
 * 时间复杂度O(n^2)
 *
 * - 一趟排序记录最小的数，放到第一个位置
 * - 再一趟排序记录列表无序区最小的数，放到第二个位置
 * ...
 * - 算法关键点：有序区和无序区、无序区最小数的位置
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 2, 1, 7, 13, 53, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
            System.out.println("第" + i + "趟" + Arrays.toString(arr));
        }
    }
}
