package tsinghua.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 思路：
 * 1. 希尔排序是一种分组插入排序算法
 * 2. 首先取一个整数，d=n/2，将元素分为d个组，每组相邻量元素之间距离为d，在各组内进行直接插入排序
 * 3. 取第二个整数d=d/2，重复上述分组排序过程，直到d=1，即所有元素在同一组内进行直接插入排序
 * 4. 希尔排序每趟并不使某些元素有序，而是使整体数据越来越接近有序，最后一趟排序使得所有数据有序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 2, 1, 3};
        System.out.println("原始" + Arrays.toString(arr));
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        int d = arr.length / 2;
        while (d >= 1) {
            insertSortGap(arr, d);
            d /= 2;
        }
    }

    public static void insertSortGap(int[] arr, int gap) {
        for (int i = gap; i < arr.length; i = i + gap) {
            int current = arr[i]; // 当前要排序的数
            int j = i - gap; // 当前有序区的最后一个数
            while (j >= 0 && arr[j] > current) { // 从有序区的右边向左边比较，移动数组，找到合适的插入位置
                arr[j + gap] = arr[j];
                j = j - gap;
            }
            arr[j + gap] = current;
        }
        System.out.println("gap" + gap + Arrays.toString(arr));
    }
}
