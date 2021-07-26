import java.lang.reflect.Array;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {5,6,2,7,1,8,9,3,4};
        int target = 882;
        Sort.bubble_method2(arr);
        System.out.println(Arrays.toString(arr));
        int index = binarySearch(target, arr);
        System.out.println("target: " + target);
        System.out.println("index:" + index);

        int num = 5;
        Arrays.sort(arr);
        System.out.println("num = " + num);
        System.out.println("有序数组arr中，第一个比" + num + "大的数的下标:" + search(arr, num));
    }

    /**
     * 二分搜索，平均时间复杂度O(logN)
     *
     * @param target 目标数字
     * @param arr    已排序数组
     * @return 目标数字索引
     */
    public static int binarySearch(int target, int[] arr) {
        int start = 0;
        int end = arr.length - 1;
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

    /**
     * 查找有序数组中第一个大于num的数
     */
    public static int search(int[] arr, int target){
        int start=0, end = arr.length-1;
        while(start <= end){
            int mid = (start + end) >> 1;
            if(arr[mid] > target){
                end = mid-1;
            } else{
                start = mid+1;
            }
        }
        if (start >= arr.length) return -1;
        return start;
    }
}
