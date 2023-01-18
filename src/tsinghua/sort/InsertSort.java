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
            int temp = arr[i]; // 无序组当前要插入的数
            int j = i - 1; // j指的是手里牌的下标
            while (j >= 0 && arr[j] > temp) { // 找到适合插入的位置
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = temp;
            System.out.println(Arrays.toString(arr));
        }
    }
}
