package zuochengyun;

/**
 * 一个无序数组，任意两个相邻元素都不相等，找到一个局部最小值。
 * 局部最小不是全局最小
 * 要求时间复杂度O(logN)
 */
public class LocalMinimum {
    public static void main(String[] args) {

        // 这种情况arr[0] < arr[1] 直接返回0
        System.out.println(getLessIndex(new int[]{1, 2, 3, 4, 5}));

        // 直接返回arr[length-1]
        System.out.println(getLessIndex(new int[]{8, 2, 5, 7, 6, 4, 7, 2, 3, 1}));

        // 局部最小值在中间，二分寻找
        System.out.println(getLessIndex(new int[]{8, 2, 5, 10}));
    }

    public static int getLessIndex(int[] arr) {
        if (null == arr || 0 == arr.length) {
            return -1;
        }
        if (1 == arr.length || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int left = 1, right = arr.length - 2;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid - 1] < arr[mid]) {
                right = mid - 1;
            } else if (arr[mid + 1] < arr[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
