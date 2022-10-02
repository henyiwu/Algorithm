package offer;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 */
public class Title55_2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        boolean isBalanced = true;

        public boolean isBalanced(TreeNode root) {
            maxDepth(root);
            return isBalanced;
        }

        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            int leftMax = maxDepth(root.left);
            int rightMax = maxDepth(root.right);
            int maxDepth = 1 + Math.max(leftMax, rightMax);
            if (Math.abs(leftMax - rightMax) >= 2) {
                isBalanced = false;
            }
            return maxDepth;
        }
    }
}
