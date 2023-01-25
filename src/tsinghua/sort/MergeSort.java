package tsinghua.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 排序思路：
 * 1. 分解：将列表越分越小，直至分成一个元素
 * 2. 终止条件：一个元素是有限的
 * 3. 合并：将两个有序列表归并，列表越来越大
 *
 * 时间复杂度O(NlogN)
 * 空间复杂度O(N)
 *
 * 需要额外空间，非原地排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 3, 7, 1, 4};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        mergeSortRecursion(arr, 0, arr.length - 1);
    }

    /**
     * 递归合并
     * @param low 最低位下标
     * @param high 最高位下标
     */
    public static void mergeSortRecursion(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSortRecursion(arr, low, mid);
        mergeSortRecursion(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    /**
     * 合并数组
     *
     * @param arr  待排序数组
     * @param low  最低位下标
     * @param mid  中位下标
     * @param high 最高位下标
     */
    public static void merge(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int index = 0;
        int[] temp = new int[high - low + 1];
        while (i <= mid && j <= high) {
            if (arr[i] > arr[j]) {
                temp[index++] = arr[j++];
            } else {
                temp[index++] = arr[i++];
            }
        }
        while (i <= mid) {
            temp[index++] = arr[i++];
        }
        while (j <= high) {
            temp[index++] = arr[j++];
        }
        int tempIndex = 0;
        for (int k = low; k <= high; k++) {
            arr[k] = temp[tempIndex++];
        }
    }
}
