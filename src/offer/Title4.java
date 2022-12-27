package offer;

/**
 * 二维数组中的查找
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序，
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * <p>
 * 例如
 * 1 2 8 9
 * 2 4 9 12
 * 4 7 10 13
 * 6 8 11 15
 * <p>
 * 查找7，返回true
 * 查找5，返回false
 */
public class Title4 {
    public static void main(String[] args) {
        int[][] arr = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        findNum(arr, 20);
    }

    /**
     * 从数组的右上角开始找，
     * 如果刚好是要找的数字，返回
     * 如果右上角数字比target大，该列数字去除，j--
     * 否则查找下一列，即i++
     */
    public static boolean findNum(int[][] arr, int target) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        int i = 0; // 右上角横坐标
        int j = arr[0].length - 1; // 右上角纵坐标

        while (j >= 0 && i < arr.length) {
            if (arr[i][j] == target) {
                return true;
            } else if (arr[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}

