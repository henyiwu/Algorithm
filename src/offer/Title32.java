package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
 */
public class Title32 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            LinkedList<TreeNode> currentLevel = new LinkedList<>();
            currentLevel.add(root);
            while (!currentLevel.isEmpty()) {
                LinkedList<TreeNode> nextLevel = new LinkedList<>();
                LinkedList<Integer> level = new LinkedList<>();
                while (!currentLevel.isEmpty()) {
                    TreeNode treeNode = currentLevel.pollFirst();
                    if (treeNode != null) {
                        level.add(treeNode.val);
                    }
                    if (treeNode.left != null) {
                        nextLevel.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        nextLevel.add(treeNode.right);
                    }
                }
                currentLevel = nextLevel;
                result.add(level);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode6 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        Solution solution = new Solution();
        System.out.println(solution.levelOrder(treeNode1));
    }
}
