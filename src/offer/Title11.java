package offer;


/**
 * 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素，例如
 * {3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1
 */
public class Title11 {

    public static void main(String[] args) {

    }

    public int minArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > array[right]) {
                left = mid + 1;
            } else if (array[mid] < array[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return array[left];
    }
}
