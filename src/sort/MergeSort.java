package sort;

import java.util.Arrays;

public class MergeSort {

    private static int[] aux;

    public static void main(String[] args) {
        int[] arr = {1,3,4,2,5};
//        sort(arr);
//        System.out.println(Arrays.toString(arr));
        System.out.println(smallSum(arr));
    }

    /**
     * 排序入口
     */
    public static void sort(int[] arr) {
        aux = new int[arr.length];
        sort(arr, 0, arr.length-1);
    }

    public static void sort(int[] arr, int start, int end) {
        if (end <= start) return;
        int mid = start + (end - start) / 2;
        sort(arr, start, mid);
        sort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    /**
     * 把左右已经有序的数组合并
     */
    public static void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        for (int k = start; k <= end; k++) {
            aux[k] = arr[k];
        }
        for (int k = start; k <= end; k++) {
            if (i > mid) arr[k] = aux[j++]; // 数组左边已经遍历完，直接使用右边的数
            else if (j > end) arr[k] = aux[i++]; // 数组右边已经遍历完，直接使用左边的数
            else if (aux[j] < aux[i]) arr[k] = aux[j++]; // 如果数组右边的数比较小，使用右边的数
            else arr[k] = aux[i++]; // 如果数组左边的数比较小，使用左边的数
        }
    }

    /**
     * 求小和入口
     */
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length <= 1) return 0;
        aux = new int[arr.length];
        return process(arr, 0, arr.length-1);
    }

    public static int process(int[] arr, int start, int end) {
        if (start == end) return 0;
        int mid = (start + end) / 2;
        return process(arr, start, mid) + process(arr, mid + 1, end) + mergeAndSmallSum(arr, start, mid, end);
    }

    /**
     * 归并排序并求小和
     * 小和：把每一个数左边比当前数小的数累加起来,叫做这个数组的小和
     * 比如:[1,2,3,4,5]
     * 1的左边没有数，小和是：0
     * 2的左边有1比它小，小和是：1
     * 3的左边有1，2比它小，小和是：3
     * 4的左边有1，2，3比它小，小和是6，
     * 5的左边有1，2，3，4比它小，小和是10，
     * 所有小和加起来是20
     *
     * 基本思路：求小和可以等同为，遍历数组，查看当前值arr[i]右边有多少个数比arr[i]大，
     * 说明arr[i]就会被记录多少次小和，再把所有数加起来。
     * 结合归并排序是为了让数不重复计算，也不漏算，且每个数都有机会成为被别的数算为小和的数，或者以这个数为准来算小和。
     */
    public static int mergeAndSmallSum(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int result = 0;
        for (int k = start; k <= end; k++) {
            aux[k] = arr[k];
        }
        // 取小和时，如果遇到两个数相等的情况，要优先合并右边的数，否则求小和结果不对（虽然排序正确）
        for (int k = start; k <= end; k++) {
            if (i > mid) arr[k] = aux[j++];
            else if (j > end) arr[k] = aux[i++];
            else if (aux[i] < aux[j]) {
                result += aux[i] < aux[j] ? (end-j+1) * aux[i]: 0;
                arr[k] = aux[i++];
            }
            else arr[k] = aux[j++];
        }
        return result;
    }
}
