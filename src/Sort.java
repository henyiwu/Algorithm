public class Sort {

    /**
     * 快速排序
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
}
