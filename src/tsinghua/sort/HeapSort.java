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
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆调整
     *
     * @param arr 列表
     */
    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) { // (arr.length / 2)表示最后一个非叶节点
            adjustHeap(arr, i, arr.length);
        }
        /*
         * 将堆项元素与末尾元素交换，将最大元素"沉"到数组末端;
         * 重新调整结构，使其满足堆定义，然后继续交换堆项元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
         */
        for (int j = arr.length - 1; j > 0; j--) {
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }


    /**
     * 将一个数组（二叉树）调整成一个大根堆
     * 功能：完成将以i对应的非叶子结点的树调整成大顶堆
     * 举例int arr[]={4,6,8,5,9};=>i=1=> adjustHeap=>得到{4,9,8,5,6}
     * 如果我们再次调用adjustHeap 传入的是i=0=>得到{4,9,8,5,6}=> {9,6,8,5,4}
     *
     * @param arr  待调整的数组
     * @param low  表示非叶子结点在数组中索引
     * @param length 表示对多少个元素继续调整，length 是在逐渐的减少
     */
    public static void adjustHeap(int[] arr, int low, int length) {
        int root = arr[low];//先取出当前元素的值，保存在临时变量
        for (int k = low * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) { // 当前节点有右孩子，且右孩子比左孩子大
                k++; // k指向右孩子
            }
            if (arr[k] > arr[low]) { // 是否有孩子比父（当前）节点大
                arr[low] = arr[k];
                low = k;
            } else {
                break;
            }
        }
        arr[low] = root;
    }
}
