package algorithms.chapter1;

import java.util.Arrays;

/**
 * 二分查找
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
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
