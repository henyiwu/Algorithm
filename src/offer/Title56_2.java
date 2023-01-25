package offer;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 */
public class Title56_2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 4, 3, 3};
        solution.singleNumber(arr);
    }

    static class Solution {
        public int singleNumber(int[] nums) {
            AtomicInteger result = new AtomicInteger();
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int num : nums) {
                Integer count = hashMap.get(num);
                if (count == null) {
                    count = 0;
                }
                hashMap.put(num, ++count);
            }
            hashMap.keySet().forEach(integer -> {
                if (hashMap.get(integer) == 1) {
                    result.set(integer);
                }
            });
            return result.get();
        }
    }
}
