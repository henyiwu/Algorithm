package sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {4, 6, 1, 2, 5};
        selectSort(arr);
        System.out.println("result:" + Arrays.toString(arr));
    }

    /**
     * 原数据:[4, 6, 1, 2, 5]
     * 第1趟: [1, 6, 4, 2, 5]
     * 第2趟: [1, 2, 6, 4, 5]
     * 第3趟: [1, 2, 4, 6, 5]
     * 第4趟: [1, 2, 4, 5, 6]
     * result:[1, 2, 4, 5, 6]
     *
     *
     *
     * 1 2 2 3 4 5 5 5 6 7 7 7 8 8 8 9
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        System.out.println("原数据:" + Arrays.toString(arr));
        // 假设index = 0是最小的，如果后面的数比第0位的数还小，交换位置
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    swap(arr, j, i);
                }
            }
            System.out.println("第" + (i + 1) + "趟: " + Arrays.toString(arr));
        }
    }

    /**
     * 异或操作交换两数
     */
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
