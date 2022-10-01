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
        int[] arr = {1, 2, 10, 4, 1, 4, 3, 3};
        int[] ints = solution.singleNumbers(arr);
        System.out.println(Arrays.toString(ints));
    }

    static class Solution {
        public int[] singleNumbers(int[] nums) {
            // 1. 遍历数组，异或所有数字，得到一个异或结果
            int temp = 0;
            for (int num : nums) {
                temp = temp ^ num;
            }

            // 2. 从低位往高位取，得到一个第一位是1，其他都是0的数字
            int value = 1;
            while ((value & temp) == 0) {
                value = value << 1;
            }

            // 3. 将所有数字与步骤2得到的数字进行与操作，将数组分开
            int a = 0;
            int b = 0;
            for (int num : nums) {
                if ((num & value) != 0) {
                    a = a ^ num;
                } else {
                    b = b ^ num;
                }
            }
            return new int[]{a, b};
        }
    }
}
