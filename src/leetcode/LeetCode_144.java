package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
给你二叉树的根节点 root ，返回它节点值的 前序 遍历。

示例 1：

输入：root = [1,null,2,3]
输出：[1,2,3]
示例 2：

输入：root = []
输出：[]
示例 3：

输入：root = [1]
输出：[1]
示例 4：


输入：root = [1,2]
输出：[1,2]
示例 5：


输入：root = [1,null,2]
输出：[1,2]
 

提示：

树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100
 */
public class LeetCode_144 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            return helper(root, arrayList);
        }

        public List<Integer> helper(TreeNode treeNode, ArrayList<Integer> arrayList) {
            if (treeNode == null) {
                return arrayList;
            }
            arrayList.add(treeNode.val);
            helper(treeNode.left, arrayList);
            helper(treeNode.right, arrayList);
            return arrayList;
        }
    }
}
