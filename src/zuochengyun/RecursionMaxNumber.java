package zuochengyun;

import java.util.Arrays;

/**
 * 递归求数组中最大的数
 */
public class RecursionMaxNumber {

    public static void main(String[] args) {
        int maxValue = 100;
        int maxSize = 100;
        for (int i = 0; i < 100; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int max1 = getMax(arr1, 0, arr1.length-1);
            int max2 = getMaxEasy(arr2);
            System.out.println(max1 == max2);
            System.out.println(Arrays.toString(arr1));
        }
    }

    public static int getMaxEasy(int[] arr) {
        int max = 0;
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }

    /**
     * 递归求数组最大值
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int getMax(int[] arr, int left, int right) {
        if (left == right) return arr[left];
        int mid = left + ((right - left) >> 1);
        int leftMax = getMax(arr, left, mid);
        int rightMax = getMax(arr, mid+1, right);
        return Math.max(leftMax, rightMax);
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}
