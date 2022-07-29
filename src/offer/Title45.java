package offer;

/*
剑指 Offer 45. 把数组排成最小的数
输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。

示例 1:

输入: [10,2]
输出: "10 2"
示例 2:

输入: [3,30,34,5,9]
输出: "30 3 34 5 9"

提示:
0 < nums.length <= 100
说明:

输出结果可能非常大，所以你需要返回一个字符串而不是整数
拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 */
public class Title45 {

    static class Solution {
        public String minNumber(int[] numbers) {
            for (int i = 0; i < numbers.length; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    String x = numbers[i] + "" + numbers[j];
                    String y = numbers[j] + "" + numbers[i];
                    if (Long.parseLong(x) > Long.parseLong(y)) {
                        swap(numbers, i, j);
                    }
                }
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int number : numbers) {
                stringBuilder.append(number);
            }
            return stringBuilder.toString();
        }

        public void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {10, 2};
        System.out.println(solution.minNumber(arr));
    }
}
