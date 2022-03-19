package sort;

import java.util.Arrays;

public class MergeSort {

    private static int[] aux;

    public static void main(String[] args) {
        int[] arr = {6,2,1,7,3,5,9,52,12,33,624,6,1,2,6,2,13,6,134,6,16,13,61,61,361,361,6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

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
}
