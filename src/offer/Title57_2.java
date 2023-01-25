package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * 限制：
 * <p>
 * 1 <= target <= 10^5
 */
public class Title57_2 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] continuousSequence = solution.findContinuousSequence(6);
        System.out.println();
    }

    static class Solution {
        /**
         * 滑动窗口，设置左右指针，找到一个左右指针内所有数字相加得到target的数字，
         * 就将该组数添加到数组中
         */
        public int[][] findContinuousSequence(int target) {
            int i = 1; // 滑动窗口的左边界
            int j = 1; // 滑动窗口的右边界
            int sum = 0; // 滑动窗口中数字的和
            List<int[]> res = new ArrayList<>();

            while (i <= target / 2) {
                if (sum < target) {
                    // 右边界向右移动
                    sum += j;
                    j++;
                } else if (sum > target) {
                    // 左边界向右移动
                    sum -= i;
                    i++;
                } else {
                    // 记录结果
                    int[] arr = new int[j - i];
                    for (int k = i; k < j; k++) {
                        arr[k - i] = k;
                    }
                    res.add(arr);
                    // 左边界向右移动
                    sum -= i;
                    i++;
                }
            }

            return res.toArray(new int[res.size()][]);
        }
    }
}
