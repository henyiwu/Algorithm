package zuochengyun;

import java.util.Arrays;

/**
 * 荷兰国旗问题
 */
public class NetherlandsFlag {

    public static void main(String[] args) {
        int[] arr = {5,2,6,4,1,7,4,3,4,4,1,5,7,2,25,25,1435,31,1,71,13,135,13,134,51345,24};
//        partition(arr, 4, 0, arr.length-1);
        partitionEqualOrLessThan(arr, 100);
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
