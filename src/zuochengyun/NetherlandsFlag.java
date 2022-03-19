package zuochengyun;

import java.util.Arrays;

/**
 * 荷兰国旗问题
 */
public class NetherlandsFlag {

    public static void main(String[] args) {
        int[] arr = {1,4,2,5,3};
//        partition(arr, 4, 0, arr.length-1);
        partitionEqualOrLessThan(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public static void partition(int[] arr, int p, int L, int R) {
        int less = L - 1;
        int more = R + 1;
        int index = L;
        while (index < more) {
            if (arr[index] < p) {
                swap(arr, ++less, index++);
            } else if (arr[index] > p) {
                swap(arr, --more, index);
            } else {
                index++;
            }
        }
    }

    /**
     * 小于等于p的数放在左边，大于等于p的数放在右边，是荷兰问题的简化
     * 准备一个下标less，表示小于等于p的下标区域，初始化为-1
     * 1. 遇到小于等于p的数，把less的下一个和index对应的数交换，并且index++
     * 2. 遇到大于p的数，index++
     * 这样的目的是找出小于等于p的数，放到小于等于区，且小于等于区扩张
     * 例如：
     * [1,4,2,5,3] p = 3
     * step1: | [1,4,2,5,3]
     * step2:  [1 |,4,2,5,3] index = 0
     * step3:  [1 |,4,2,5,3] index = 1
     * step4:  [1,,2|,4,5,3] index = 2
     * step4:  [1,,2|,4,5,3] index = 3
     * step5:  [1,,2,3|,5,4] index = 3
     */
    public static void partitionEqualOrLessThan(int[] arr, int p) {
        int less = -1;
        int index = 0;
        while (index < arr.length) {
            if (arr[index] <= p) {
                swap(arr, ++less, index++);
            } else {
                index++;
            }
        }
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
