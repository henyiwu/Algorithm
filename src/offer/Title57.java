package offer;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 剑指 Offer 57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * <p>
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * <p>
 * 限制：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 */
public class Title57 {

    public static void main(String[] args) {

    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashSet<Integer> hashSet = new HashSet<>();
            int[] result = new int[2];
            for (int value : nums) {
                if (hashSet.contains(target - value)) {
                    result[0] = value;
                    result[1] = target - value;
                    return result;
                }
                hashSet.add(value);
            }
            return result;
        }
    }
}
