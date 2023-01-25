package offer;

/*
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。

参考以下这颗二叉搜索树：

     5
    / \
   2   6
  / \
 1   3
示例 1：

输入: [1,6,3,2,5]
输出: false
示例 2：

输入: [1,3,2,6,5]
输出: true
 */
public class Title33 {

    static class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return recur(postorder, 0, postorder.length - 1);
        }

        /**
         *
         * [5, 2, 6, 1, 3]
         *
         *      5
         *     / \
         *    2   6
         *   / \
         *  1   3
         *
         *  input : [1,3,2,6,5]
         *
         *  以下解法假设输入的数组符合规则
         */
        boolean recur(int[] postorder, int i, int j) {
            if (i >= j) return true;
            int p = i;
            // 找到根节点的右子节点
            while (postorder[p] < postorder[j]) p++;
            int m = p;
            // postorder[j]是根节点，postorder[p]是根节点右边的所有节点，一定比根节点大
            while (postorder[p] > postorder[j]) p++;
            // 如果是二叉搜索树的后序遍历，p一定和j相等
            // 再遍历根节点左边的节点 和 根节点右边的节点
            return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,3,2,6,5};
        System.out.println(solution.verifyPostorder(arr));
    }
}
