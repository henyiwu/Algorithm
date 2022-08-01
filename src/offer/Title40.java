package offer;

import java.lang.reflect.Array;
import java.util.ArrayList;

/*
剑指 Offer 40. 最小的k个数
输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。



示例 1：

输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]
示例 2：

输入：arr = [0,1,2,1], k = 1
输出：[0]


限制：

0 <= k <= arr.length <= 10000
0 <= arr[i] <= 10000
 */
public class Title40 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                arrayList.add(arr[i]);
            }

            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = getMinAndRemove(arrayList);
            }

            return result;
        }

        private int getMinAndRemove(ArrayList<Integer> arrayList) {
            if (arrayList == null) {
                return -1;
            }
            int min = arrayList.get(0);
            int minIndex = 0;
            for (int i = 1; i < arrayList.size(); i++) {
                if (arrayList.get(i) < min) {
                    min = arrayList.get(i);
                    minIndex = i;
                }
            }
            arrayList.remove(minIndex);
            return min;
        }
    }
}
