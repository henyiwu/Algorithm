package offer;

/**
 * 剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * <p>
 * 提示：
 * <p>
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 */
public class Title66 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3, 4, 5};
        int[] ints = solution.constructArr(arr);
        System.out.println(ints.length);
    }

    static class Solution {
        /**
         * 暴力解法，超出时间限制
         */
//        public int[] constructArr(int[] a) {
//            int[] result = new int[a.length];
//            for (int i = 0; i < result.length; i++) {
//                int temp = 1;
//                for (int j = 0; j < a.length; j++) {
//                    if (i == j) {
//                        continue;
//                    }
//                    temp *= a[j];
//                }
//                result[i] = temp;
//            }
//            return result;
//        }

        public int[] constructArr(int[] a) {
            int[] result = new int[a.length];
            int temp = 1;
            // 循环1，把a[i]左边的所有数相乘，赋值给a[i]
            for (int i = 0; i < a.length; i++) {
                result[i] = temp;
                temp = temp * a[i];
            }

            // 循环2，把a[i]右边的所有数相乘，赋值给a[i]
            temp = 1;
            for (int i = a.length - 1; i >= 0; i--) {
                result[i] = result[i] * temp;
                temp = temp * a[i];
            }

            return result;
        }
    }
}
