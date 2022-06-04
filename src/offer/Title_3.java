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

    /**
     * 不是拿数组二分，是拿1~7这七个数二分
     */
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
                    System.out.println("找到重复数字");
                    return start;
                } else {
                    System.out.println("没有重复数字");
                    break;
                }
            }
            // 重复的数字在start~middle范围内
            if (count > (middle - start + 1)) {
                end = middle;
            } else { // 重复的数字在middle+1~end范围内
                start = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 看start到end这个闭区间内，数组中数字出现多少次，
     * 例如{3,2,4,2,1}，在start=1，end=3中，出现4次
     */
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
