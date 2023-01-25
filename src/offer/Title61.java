package offer;

import java.util.HashSet;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，
 * A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * 示例 2:
 * <p>
 * 输入: [0,0,1,2,5]
 * 输出: True
 * <p>
 * 限制：
 * <p>
 * 数组长度为 5
 * <p>
 * 数组的数取值为 [0, 13] .
 */
public class Title61 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0, 0, 1, 2, 5};
        System.out.println(solution.isStraight(arr));
    }

    static class Solution {
        public boolean isStraight(int[] nums) {
            int max = 0;
            int min = 14;
            HashSet<Integer> hashSet = new HashSet<>();
            for (int num : nums) {
                // 1. 跳过大王
                if (num == 0) continue;
                // 2. 求出这组数列里的最大值和最小值
                max = Math.max(max, num);
                min = Math.min(min, num);
                // 3. 又重复的一定不是顺子
                if (hashSet.contains(num)) {
                    return false;
                }
                hashSet.add(num);
            }
            // 最大值和最小值的差小于5，则是顺子
            return Math.abs(max - min) < 5;
        }
    }
}
