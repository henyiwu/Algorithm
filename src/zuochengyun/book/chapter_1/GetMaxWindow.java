package zuochengyun.book.chapter_1;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 有一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向右边滑动一个位置，
 * 例如，数组为[4,3,5,4,3,3,6,7]，窗口大小为3时：
 * [4 3 5] 4 3 3 6 7 max=5
 * 4 [3 5 4] 3 3 6 7 max=5
 * 4 3 [5 4 3] 3 6 7 max=5
 * 4 3 5 [4 3 3] 6 7 max=4
 * 4 3 5 4 [3 3 6] 7 max=6
 * 4 3 5 4 3 [3 6 7] max=7
 */
public class GetMaxWindow {
    public static void main(String[] args) {
        int[] arr = {4,3,5,4,3,3,6,7};
        System.out.println(Arrays.toString(getMaxWindow2(arr, 3)));
    }

    /**
     * 时间复杂度为 O(N*w)
     * @param arr 原始数组
     * @param w 窗口大小
     * @return 结果数组
     */
    public static int[] getMaxWindow(int[] arr, int w) {
        int[] tempArr = new int[arr.length-w+1];
        for (int i = 0; i < arr.length-w+1; i++) {
            int max = arr[i];
            for (int j = i; j < i+w; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
            tempArr[i] = max;
        }
        return tempArr;
    }

    /**
     * 时间复杂度为O(N)
     * 步骤：
     * 1.如果qMax为空，直接把下标i放进qMax，放入过程结束
     * 2.如果qMax不为空，取出当前qMax队列尾的下标，假设为j
     * 如果arr[j]>arr[i]，把下标i放入qMax队尾，过程结束
     * 如果arr[j]<=arr[i]，把j从对尾弹出，继续qMax的放入规则
     * 假设遍历到arr[i]，qMax的弹出规则为：如果qMax队头的下标等于i-w，说明当前qMax队头的下标已经过期，
     * 弹出当前队头的下标。
     * @param arr 输入数组
     * @param w 滑动窗口大小
     * @return
     */
    public static int[] getMaxWindow2(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qMax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[i]) {
                qMax.pollLast();
            }
            qMax.addLast(i);
            // 有可能一个比较大的数，一直在qMax的队头，但此时窗口滑动后已经不包含这个数，把它移除
            if (qMax.peekFirst() == i - w) {
                qMax.pollFirst();
            }
            // 例如w=3，则i>=2之后满足要求，表示只有i>=2之后才能把qMax的队头放入res数组
            if (i >= w - i) {
                res[index++] = arr[qMax.peekFirst()];
            }
        }
        return res;
    }
}
