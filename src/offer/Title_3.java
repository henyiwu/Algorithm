package offer;

/**
 * 不能修改数组找出重复的数字
 * 在一个长度为n+1的数组里，所有数字都在1~n的范围内，所以数组中至少有一个数字是重复的，
 * 请找出数组中任意一个重复的数字，但不能修改输入的数组，
 * 例如：{2,3,5,4,3,2,6,7}，长度为8的数组，那么输出的数字是2或者3
 */
public class Title_3 {
    public static void main(String[] args) {
        int[] arr = {2,3,5,4,1,2,6,7};
        System.out.println(getDuplication(arr));
    }

    static int getDuplication(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        int start = 1;
        int end = arr.length - 1;
        while (end >= start) {
            int middle = (start + end) / 2;
            int count = countRange(arr, start, middle);
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    static int countRange(int[] arr, int start, int end) {
        if (arr == null) return 0;
        int count = 0;
        for (int j : arr) {
            if (j >= start && j <= end) {
                count++;
            }
        }
        return count;
    }
}
