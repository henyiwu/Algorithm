package offer;

import java.util.ArrayList;
import java.util.Arrays;

/*
剑指 Offer 54. 二叉搜索树的第k大节点
给定一棵二叉搜索树，请找出其中第 k 大的节点的值。

示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 4

限制：

1 ≤ k ≤ 二叉搜索树元素个数
 */
public class Title54 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 中序遍历
   static class Solution {

        public int kthLargest(TreeNode root, int k) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            recur(root, arrayList);
            return arrayList.get(arrayList.size() - k);
        }

        public void recur(TreeNode root, ArrayList<Integer> arrayList) {
            if (root == null) {
                return;
            }
            recur(root.left, arrayList);
            arrayList.add(root.val);
            recur(root.right, arrayList);
        }
    }
}
