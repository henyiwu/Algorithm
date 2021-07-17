public class Sort {

    /**
     * 快速排序
     * 平均时间复杂度：O(NlogN)
     * 最优时间复杂度：O(logN)，即每一次都平均分数组
     * 最差的时间复杂度：O(N)，退化为冒泡排序
     * @param start 数组起始数
     * @param end 数字结尾数
     * @param arr 待排序数组
     */
    public static void quickSort(int start, int end, int[] arr) {
        if (start > end) return;
        int left = start;
        int right = end;
        int base = arr[left];
        while (left < right) {
            while (left < right && arr[right] > base) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] < base) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = base;
        quickSort(start, left-1, arr);
        quickSort(left+1, end, arr);
    }

    public static void quickSort(int[] arr) {
        quickSort(0, arr.length-1, arr);
    }

//---------------------------------------------------

    /**
     * 冒泡排序
     * 平均时间复杂度：O(N^2)
     * 最差时间复杂度：O(N^2)
     * 最优时间复杂度：O(N)
     * @param arr 待排序数组
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = arr.length-1; i > 0; i--) {
            boolean flag = bubble(arr, i);
            if (flag) return;
        }
    }

//    /**
//     * 每趟冒泡
//     * @param arr 待操作数组
//     * @param n 数组长度
//     */
//    public static void bubble(int[] arr, int n) {
//        for (int i = 0; i < n; i++) {
//            if (arr[i] > arr[i+1]) {
//                swap(arr, i, i+1);
//            }
//        }
//    }

    /**
     * 每趟冒泡，采用标志位优化方案
     * @param arr 待操作数组
     * @param n 待操作数组长度
     * @return 数组是否有序
     */
    public static boolean bubble(int[] arr ,int n) {
        boolean ordered = true;
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[i+1]) {
                swap(arr, i, i+1);
                ordered = false;
            }
        }
        return ordered;
    }

//----------------------------------------------------

    /**
     * 选择排序
     * @param arr 待操作数组
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

//----------------------------------------------------

    /**
     * 交换数组中的两个数
     * @param arr 待操作数据
     * @param i 下标 i
     * @param j 下表 j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
