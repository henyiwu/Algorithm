package offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
剑指 Offer 39. 数组中出现次数超过一半的数字
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例 1:

输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
输出: 2
 */
public class Title39 {

    static class Solution {
        public int majorityElement(int[] nums) {
            // 拿到所有数值的集合
            HashSet<Integer> hashSet = new HashSet<>();
            for (int num : nums) {
                hashSet.add(num);
            }
            HashMap<Integer, Integer> mapValueCount = new HashMap<>();
            for (int value : nums) {
                int count = 0;
                if (mapValueCount.get(value) != null) {
                    count = mapValueCount.get(value) + 1;
                }
                mapValueCount.put(value, count);
            }

            HashMap<Integer, Integer> mapCountValue = new HashMap<>();
            Set<Integer> integers = mapValueCount.keySet();
            for (int value : integers) {
                int count = mapValueCount.get(value);
                mapCountValue.put(count, value);
            }

            Iterator<Integer> iterator = hashSet.iterator();
            int max = 0;
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                Integer count = mapValueCount.get(next);
                if (count > max) {
                    max = count;
                }
            }

            return mapCountValue.get(max);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {6,6,6,7,7};
        System.out.println(solution.majorityElement(arr));
    }
}
