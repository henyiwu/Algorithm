package tsinghua.sort;

import java.util.Arrays;

/**
 * 插入排序算法
 * <p>
 * 思路：
 * 1. 初始时手里（有序区）只有一张牌
 * 2. 每次（从无序区）摸一张牌，插入到自己手里有牌的正确位置
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 3, 2, 1};
        insertSort(arr);
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i]; // 当前要排序的数
            int j = i - 1; // 当前有序区的最后一个数
            while (j >= 0 && arr[j] > current) { // 从有序区的右边向左边比较，移动数组，找到合适的插入位置
                arr[j + 1] = arr[j];
                j--;
            }
            arr[++j] = current;
            System.out.println("第" + i + "趟:" + Arrays.toString(arr));
        }
    }
}
