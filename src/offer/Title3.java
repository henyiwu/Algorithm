package offer;

import java.util.Arrays;

/**
 * 数组中的重复数字
 * 在一个长度位n的数组里的所有数字都在0~n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次，
 * 请找出数组中任意一个重复的数字，例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出为重复的数字2或者3
 */

public class Title3 {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 1, 1, 1};
        System.out.println(duplicate2(arr));
    }

    /**
     * 新建一个数组
     * {2,1,3,2}
     * 空间复杂度O(n)
     */
    public static int duplicate(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[arr[i]]++;
            if (result[arr[i]] >= 2) {
                return arr[i];
            }
        }
        return -1;
    }

    /**
     * 空间复杂度O(1)的方法
     * 思路：从头遍历，把当前a[i]和a[a[i]]的数字交换，直到a[i]=i，如果碰巧a[i]=a[a[i]]，这个数就是结果
     * <p>
     * 测试数据： [2, 3, 1, 0, 2, 5, 3]
     * loop0:   [1, 3, 2, 0, 2, 5, 3]
     * [3, 1, 2, 0, 2, 5, 3]
     * [0, 1, 2, 3, 2, 5, 3]   i=0位置一定是0
     * -----------------------
     * loop1:   [0, 1, 2, 3, 2, 5, 3]   i=1位置一定是1
     * -----------------------
     * loop2:   [0, 1, 2, 3, 2, 5, 3]   i=2位置一定是2
     * -----------------------
     * loop3:   [0, 1, 2, 3, 2, 5, 3]   i=3位置一定是3
     * -----------------------
     * loop4:   [0, 1, 2, 3, 2, 5, 3]   i=4位置刚好是i[i[4]]
     * return 2
     */
    public static int duplicate2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            // 假如i=0,把0放到i=0的位置
            while (i != arr[i]) {
                // 找到两个重复的数字
                if (arr[i] == arr[arr[i]]) {
                    return arr[i];
                }
                int temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
            }
        }
        return -1;
    }
}
