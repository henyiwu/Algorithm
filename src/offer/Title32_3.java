package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

 

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
  [20,9],
  [15,7]
]
 */
public class Title32_3 {
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
            List<List<Integer>> result = new LinkedList<>();
            if (root == null) {
                return result;
            }
            // 如果这一层是反着添加，则先加右节点再加左节点
            boolean isReverse = false;
            LinkedList<TreeNode> currentLevel = new LinkedList<>();
            currentLevel.add(root);
            while (!currentLevel.isEmpty()) {
                LinkedList<TreeNode> nextLevel = new LinkedList<>();
                List<Integer> currentLevelInteger = new LinkedList<>();
                while (!currentLevel.isEmpty()) {
                    TreeNode currentNode;
                    currentNode = currentLevel.pollLast();
                    if (currentNode != null) {
                        currentLevelInteger.add(currentNode.val);
                    }
                    if (isReverse) {
                        if (currentNode != null && currentNode.right != null) {
                            nextLevel.add(currentNode.right);
                        }
                        if (currentNode != null && currentNode.left != null) {
                            nextLevel.add(currentNode.left);
                        }
                    } else {
                        if (currentNode != null && currentNode.left != null) {
                            nextLevel.add(currentNode.left);
                        }
                        if (currentNode != null && currentNode.right != null) {
                            nextLevel.add(currentNode.right);
                        }
                    }
                }
                isReverse = !isReverse;
                result.add(currentLevelInteger);
                currentLevel = nextLevel;
            }
            return result;
        }
    }

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode5 = new TreeNode(15);
        TreeNode treeNode6 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;


        Solution solution = new Solution();
        System.out.println(solution.levelOrder(treeNode1));
    }
}
