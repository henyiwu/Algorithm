package tsinghua.sort;

import java.util.Arrays;

/**
 * 堆：特殊的完全二叉树
 * 大根堆：满足任意节点都比孩子大
 * 小根堆：满足任意节点都比孩子小
 * <p>
 * 思路：
 * 1. 建立堆
 * 2. 得到堆顶元素，为最大元素
 * 3. 去掉堆顶，将堆最后一个元素放到堆顶，此时可通过一次调整重新使堆有序。
 * 4. 堆顶元素为第二大元素
 * 5. 重复步骤3，直到堆变空
 * 时间复杂度O(NlogN)
 *
 * <p>
 * 使用数组存储
 * 父节点与左孩子的关系
 * i -> 2i+1
 * <p>
 * 父节点与右孩子的关系
 * i -> 2i+2
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {4, 6, 10, 8, 5, 9, 2, 3, 1, 7};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
//        int[] topKArr = topK(arr, 2);
//        System.out.println("topK:" + Arrays.toString(topKArr));
    }

    public static void heapSort(int[] arr) {
        // 初始化构建堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            maxHeapAdjust(arr, i, arr.length);
        }
        // 把第一个数和最后一个数交换，构建堆
        // 从arr.length-1开始，因为已经换掉了一个数
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeapAdjust(arr, 0, i);
        }
    }

    /**
     * 调整为大根堆
     * 时间复杂度O(logN)，走一棵树的高度
     *
     * @param arr    数组
     * @param low    根节点下标
     * @param length 需要调整的数组长度
     */
    public static void maxHeapAdjust(int[] arr, int low, int length) {
        int root = arr[low];
        for (int i = low * 2 + 1; i < length; i = i * 2 + 1) {
            if (i + 1 < length && arr[i] < arr[i + 1]) { //如果存在右孩子，且右孩子比左孩子大
                i++; // 指向右孩子
            }
            if (arr[i] > root) { // 如果子节点比根节点大
                arr[low] = arr[i]; // 把子节点的数值赋值给根节点
                low = i; // low指向子节点
            } else {
                break;
            }
        }
        // 在循环中，被移动的数，都比root大，把root赋值给low
        arr[low] = root;
    }

    /**
     * 调整为小根堆
     * 时间复杂度O(logN)，走一棵树的高度
     *
     * @param arr    数组
     * @param low    根节点下标
     * @param length 需要调整的数组长度
     */
    public static void minHeapAdjust(int[] arr, int low, int length) {
        int root = arr[low];
        for (int i = low * 2 + 1; i < length; i = i * 2 + 1) {
            if (i + 1 < length && arr[i] > arr[i + 1]) { //如果存在右孩子，且右孩子比左孩子大
                i++; // 指向右孩子
            }
            if (arr[i] < root) { // 如果子节点比根节点大
                arr[low] = arr[i]; // 把子节点的数值赋值给根节点
                low = i; // low指向子节点
            } else {
                break;
            }
        }
        // 在循环中，被移动的数，都比root大，把root赋值给low
        arr[low] = root;
    }

    /**
     * topK问题
     * 在一个数组中，输出最大的K个数字
     * <p>
     * 解决思路：
     * 1. 取列表前K个元素建立一个小根堆，堆顶就是目前第K大的数字
     * 2. 依次向后遍历原列表，对于列表中的元素，如果小于堆顶，则忽略该元素；
     * 如果大于堆顶，则将堆顶更换为该元素，并且对堆进行一次调整
     * 3. 遍历列表所有元素后，倒序弹出堆顶
     *
     * 时间复杂度O(NlogK)
     */
    public static int[] topK(int[] arr, int k) {
        // 取前k个数，构建小根堆
        for (int i = k / 2 - 1; i >= 0; i--) {
            minHeapAdjust(arr, i, k);
        }
        // 从k开始遍历，把比小根堆的根几点大的数，替换掉根节点，并且重新构建小根堆
        // 解释：小根堆的根节点是整棵树中最小的数
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > arr[0]) {
                arr[0] = arr[i];
                minHeapAdjust(arr, 0, k);
            }
        }
        // 把前k个数排序
        for (int i = k - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            minHeapAdjust(arr, 0, i);
        }
        // 输出
        int[] newArr = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            newArr[k - i - 1] = arr[i];
        }
        return newArr;
    }
}
