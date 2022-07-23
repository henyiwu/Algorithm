package offer;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回：
 * <p>
 * [3,9,20,15,7]
 */
public class Title32_1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        /**
         * 广度遍历
         */
        public int[] levelOrder(TreeNode root) {
            if (root == null) {
                return new int[0];
            }
            LinkedList<TreeNode> linkedList = new LinkedList<>();
            ArrayList<Integer> result = new ArrayList<>();
            linkedList.add(root);
            while (!linkedList.isEmpty()) {
                TreeNode popNode = linkedList.pollFirst();
                result.add(popNode.val);
                if (popNode.left != null) {
                    linkedList.add(popNode.left);
                }
                if (popNode.right != null) {
                    linkedList.add(popNode.right);
                }
            }
            int[] res = new int[result.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = result.get(i);
            }
            return res;
        }
    }
}
