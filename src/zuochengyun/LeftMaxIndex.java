package zuochengyun;

/**
 * 数组从小打大排序，找到小于等于某数字，最左边的数字下标
 */
public class LeftMaxIndex {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 3};
        int i = leftMaxIndex(arr, 1);
        System.out.println("result : " + i);
    }

    /**
     * 数组从小打大排序，找到小于等于某数字，最左边的数字下标
     * 1,2,2,3,4
     * <p>
     * 1,1,1,2,3
     */
    public static int leftMaxIndex(int[] arr, int n) {
        if (arr.length < 2) {
            return 0;
        }
        int left = 0;
        // left = 0
        // right = 4
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}