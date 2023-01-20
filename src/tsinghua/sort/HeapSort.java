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
        int[] arr = {4, 6, 8, 5, 9, 2, 3, 1, 10};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        // 初始化构建堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapAdjust(arr, i, arr.length);
        }
        // 把第一个数和最后一个数交换，构建堆
        // 从arr.length-1开始，因为已经换掉了一个数
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapAdjust(arr, 0, i);
        }
    }

    /**
     * 堆调整
     * @param arr 数组
     * @param low 根节点下标
     * @param length 需要调整的数组长度
     */
    public static void heapAdjust(int[] arr, int low, int length) {
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
}
