package offer;

/*
剑指 Offer 42. 连续子数组的最大和
输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

要求时间复杂度为O(n)。



示例1:

输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Title42 {

    static class Solution {
        public int maxSubArray(int[] nums) {
            int curMax = nums[0];
            int resultMax = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (curMax < 0) {
                    curMax = nums[i];
                } else {
                    curMax = curMax + nums[i];
                }
                // 同理
                // curMax = Math.max(nums[i], nums[i] + curMax);
                resultMax = Math.max(curMax, resultMax);
            }
            return resultMax;
        }
    }

    public static void main(String[] args) {
        int[] arr = {-1, -2, -3, -1, -2};
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(arr));
    }
}
