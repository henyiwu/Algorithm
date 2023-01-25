package tsinghua.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * <p>
 * 时间复杂度O(n^2)
 *
 * 思路
 * - 列表每两个相邻的数，如果前面的数比后面的大，则交换两个数
 * - 一趟排序完成后，则无序区减少一个数，有序区增加一个数
 * - 代码关键区：趟，无序区范围
 *
 * 优化点
 * 1. 设置isSort标志位，如果已经有序，退出循环
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {4, 7, 2, 1, 5, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) { // 整个算法要循环n-1趟
            boolean isSort = true;
            for (int j = 0; j < size - i - 1; j++) { // 每趟排序都从0到n-1-i
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSort = false;
                }
            }
            if (isSort) {
                return;
            }
            System.out.println("第" + (i + 1) + "趟：" + Arrays.toString(arr));
        }
    }
}
