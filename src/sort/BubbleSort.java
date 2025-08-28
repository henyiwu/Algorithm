package sort;


import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {4, 6, 1, 2, 52, 14, 5, 3, 10, 42};
        bubbleSort(arr);
    }

    /**
     * 原数据:[4, 6, 1, 2, 5]
     * 第1趟: [4, 1, 2, 5, 6]
     * 第2趟: [1, 2, 4, 5, 6]
     * 第3趟: [1, 2, 4, 5, 6]
     * 第4趟: [1, 2, 4, 5, 6]
     */
    public static void bubbleSort(int[] arr) {
        System.out.println("原数据:" + Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j + 1, j);
                }
            }
            System.out.println("第" + (i + 1) + "趟: " + Arrays.toString(arr));
        }
    }

    /**
     * 异或操作交换两数
     * 能这样操作的前提，两个数的内存地址不同，如果相同，这个数会变成0，因为异或两数相同结果为0
     */
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
