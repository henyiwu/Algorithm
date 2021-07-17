import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {14,54,67,882,9411,10322,44104,4444,23,13,4};
        int target = 882;
        Sort.quickSort(arr);
        System.out.println(Arrays.toString(arr));
        int index = binarySearch(target, arr);
        System.out.println("target: " + target);
        System.out.println("index:" + index);
    }

    /**
     * 二分搜索，平均时间复杂度O(logN)
     * @param target 目标数字
     * @param arr 已排序数组
     * @return 目标数字索引
     */
    public static int binarySearch(int target, int[] arr) {
        int start = 0;
        int end = arr.length -1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
