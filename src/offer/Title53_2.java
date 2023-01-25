package offer;

/*
剑指 Offer 53 - II. 0～n-1中缺失的数字
一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

示例 1:

输入: [0,1,3]
输出: 2
示例 2:

输入: [0,1,2,3,4,5,6,7,9]
输出: 8
 */
public class Title53_2 {

    public static void main(String[] args) {

    }

    class Solution {
        public int missingNumber(int[] nums) {
            int[] newNums = new int[nums.length+1];
            for (int i = 0; i < nums.length; i++) {
                newNums[i] = nums[i];
            }
            newNums[nums.length] = 0;
            for (int i = 0; i < newNums.length; i++) {
                if (newNums[i] != i) {
                    return i;
                }
            }
            return 0;
        }
    }
}
