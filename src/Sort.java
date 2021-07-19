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
            boolean flag = bubble_method1(arr, i);
            if (flag) return;
        }
    }

    /**
     * 每趟冒泡
     * @param arr 待操作数组
     * @param n 数组长度
     */
    public static void bubble(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[i+1]) {
                swap(arr, i, i+1);
            }
        }
    }

    /**
     * 冒泡排序写法1，每趟冒泡，采用标志位优化方案，这种优化方案适用于前面连片的数组，对于5，1，2，3，4之类的数组结构，
     * 效果不佳。
     * @param arr 待操作数组
     * @param n 待操作数组长度
     * @return 数组是否有序
     */
    public static boolean bubble_method1(int[] arr ,int n) {
        boolean isSorted = true;
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[i+1]) {
                swap(arr, i, i+1);
                isSorted = false;
            }
        }
        return isSorted;
    }

    /**
     * 冒泡排序优化方案：记录上一次发生交换的下标
     */
    public static void bubble_method2(int[] arr) {
        if (arr == null || arr.length < 2) return;
        boolean isSorted = true;
        int pos = 0;
        int k = arr.length - 1;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < k; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                    isSorted = false;
                    pos = j;
                }
            }
            if (isSorted) return;
            k = pos;
        }
    }

//----------------------------------------------------

    /**
     * 选择排序
     * @param arr 待操作数组
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * 快速排序优化方案：
     * 外排序设置左右指针，记录最大和最小下标，可减少循环次数
     */
    public static void selectSort_method2(int[] arr) {
        for (int left = 0, right = arr.length-1; left < right; left++, right--) {
            int minIndex = left;
            int maxIndex = right;
            for(int index = left; index <= right; index++) {
                if (arr[index] < arr[minIndex]) {
                    minIndex = index;
                }
                if (arr[index] > arr[maxIndex]) {
                    maxIndex = index;
                }
            }
            swap(arr, left, minIndex);
            if (left == maxIndex) {
                maxIndex = minIndex;
            }
            swap(arr, right, maxIndex);
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

    /**
     * 异或实现两数交换，前提是i和j不相等
     * @param arr 待操作数据
     * @param i 下标 i
     * @param j 下表 j
     */
    private static void swap_OR(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
