package tsinghua.search;

import java.util.Arrays;

/**
 * 二分查找
 *
 * 2^10 = 1024
 *
 * 如果一个数组有1024个数据
 * 使用2分查找最差情况查10次
 * 使用线性查找最差1024次
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] whiteList = {1, 2, 3, 4, 5, 6, 7};
        Arrays.sort(whiteList);
        int i = binarySearch(2, whiteList);
        System.out.println(i);
    }

    public static int binarySearch(int target, int[] arr) {
        int low = 0;
        int end = arr.length - 1;
        while (low <= end) {
            int mid = (low + end) / 2;
            if (arr[mid] == target) { // 找到数据
                return mid;
            } else if (arr[mid] > target) { // 目标值在mid的左边
                end = mid - 1;
            } else {
                low = mid + 1; // 目标值在mid的右边
            }
        }
        return -1;
    }
}
