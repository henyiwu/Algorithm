package leetcode;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 *
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 *
 * 输入：nums = [-100000]
 * 输出：-100000
 */
public class LeetCode_53 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2,1,-3}));
    }

    public static int maxSubArray(int[] nums) {
        int preMax = 0;
        int curMax = nums[0];
        for (int item : nums) {
            // 一定包括了当前item
            preMax = Math.max(item, item + preMax);
            // 如果加上当前item反而小，可以舍弃掉
            curMax = Math.max(curMax, preMax);
        }
        return curMax;
    }
}
