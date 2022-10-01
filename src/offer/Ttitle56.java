package offer;

import com.oracle.tools.packager.Log;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 示例 1：
 * 中等
 * <p>
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 * <p>
 * 限制：
 * <p>
 * 2 <= nums.length <= 10000
 * <p>
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class Ttitle56 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,10,4,1,4,3,3};
        int[] ints = solution.singleNumbers(arr);
        System.out.println(Arrays.toString(ints));
    }

    static class Solution {
        public int[] singleNumbers(int[] nums) {
            // 1.将所有数字异或，得到a与b异或的结果
            int ret = 0;
            for (int n : nums) {
                ret ^= n;
            }

            // 从地位开始找，找到一位是1，其他都是0的数字
            // 比如两数异或的结果为8,则应该得到数1000，其中1这个位，能保证结果的两个数一定有一个是1一个是0
            int div = 1;
            while ((div & ret) == 0) {
                div = div << 1;
            }

            // 获得结果
            int a = 0, b = 0;
            for (int n : nums) {
                // 与操作，两个都是1才是1，所以这里只可能有一个数字进if
                if ((div & n) != 0) {
                    a ^= n;
                } else {
                    b ^= n;
                }
            }
            return new int[]{a, b};
        }
    }
}
