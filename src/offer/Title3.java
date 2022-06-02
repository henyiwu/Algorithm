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
        System.out.println(duplicate(arr));
    }

    /**
     * 新建一个数组
     * {2,1,3,2}
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
}
