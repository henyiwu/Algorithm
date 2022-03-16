package sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int arr[] = {1,4,3,1,52,5,2,50,51};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) { // 0~i有序
            // 每个子数组，后一位比前一位小时，交换两个数
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j+1, j);
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
