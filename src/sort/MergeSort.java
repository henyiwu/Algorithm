package sort;

import java.util.Arrays;

public class MergeSort {

    private static int[] aux;

    public static void main(String[] args) {
        int[] arr = {6,2,1,7,3,5,9,52,12,33,624,6,1,2,6,2,13,6,134,6,16,13,61,61,361,361,6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] a) {
        aux = new int[a.length];
        sort(a, 0, a.length-1);
    }

    public static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void merge(int[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++]; // 数组左边已经遍历完，直接使用右边的数
            else if (j > hi) a[k] = aux[i++]; // 数组右边已经遍历完，直接使用左边的数
            else if (aux[j] < aux[i]) a[k] = aux[j++]; // 如果数组右边的数比较小，使用右边的数
            else a[k] = aux[i++]; // 如果数组左边的数比较小，使用左边的数
        }
    }
}
