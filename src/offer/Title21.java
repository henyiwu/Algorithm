package offer;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 50000
 * 0 <= nums[i] <= 10000
 */
public class Title21 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] exchange = exchange(arr);
        System.out.println(Arrays.toString(exchange));
    }

    public static int[] exchange(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            while (start < end && isSingle(nums[start])) {
                start++;
            }
            while (start < end && !isSingle(nums[end])) {
                end--;
            }
            swap(nums, start, end);
        }
        return nums;
    }

    public static boolean isSingle(int num) {
        return num % 2 == 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
