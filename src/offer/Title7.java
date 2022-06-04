package offer;

/**
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历结果，重建该二叉树
 * 输入的前序遍历和中序遍历的结果中都不含重复的数字
 */
public class Title7 {

    public static void main(String[] args) {
        int[] preOrder = {1,2,4,7,3,5,6,8};
        int[] inOrder = {4,7,2,1,5,3,8,6};
        buildTree(preOrder, inOrder);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return help(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * 前序[1][2,4,7][3,5,6,8]
     * 中序[4,7,2][1][5,3,8,6]
     */
    private static TreeNode help(int[] preorder, int[] inorder, int left, int right, int left1, int right1) {
        if (left >= preorder.length || left1 >= inorder.length || left > right || left1 > right1) {
            return null;
        }
        int value = preorder[left];
        TreeNode node = new TreeNode(value);
        int count = left1;

        /* 在中序遍历中找到位置并且计算长度 */
        while (inorder[count] != value) {
            count++;
        }
        count = count - left1;

        node.left = help(preorder, inorder, left + 1, left + count, left1, left1 + count - 1);
        node.right = help(preorder, inorder, left + count + 1, right, left1 + count + 1, right1);

        return node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
