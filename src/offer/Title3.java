package offer;

/**
 * 数组中的重复数字
 * 在一个长度位n的数组里的所有数字都在0~n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次，
 * 请找出数组中任意一个重复的数字，例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出为重复的数字2或者3
 */

public class Title3 {
    public static void main(String[] args) {
        int[] arr = {2,3,1,0,2,5,3};
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
     * {2,3,1,0,2,5,3}
     * 每个数先与自己的下标比较，如果不相等，进入循环，相等跳下一个
     * 如果下标与下标上的数对应的数组中的数相等，返回这个数（重复了），比如arr[0]=2与arr[2]=2符合条件
     * 否则交换这两个数，重复上述步骤
     */
    public static int duplicate2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i) {
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
