package offer;

/**
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历结果，重建该二叉树
 * 输入的前序遍历和中序遍历的结果中都不含重复的数字
 *
 * 中等
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
     * @param preorder 前序遍历数字
     * @param inorder 中毒遍历数组
     * @param preLeft 前序遍历数组中左子树left
     * @param preRight 前序遍历数组中右子树right
     * @param midLeft 中序遍历数组中左子树left
     * @param midRight 中序遍历数组中右子树right
     * @return 根节点
     */
    private static TreeNode help(int[] preorder, int[] inorder, int preLeft, int preRight, int midLeft, int midRight) {
        if (preLeft >= preorder.length || midLeft >= inorder.length || preLeft > preRight || midLeft > midRight) {
            return null;
        }
        /* 前序遍历数组中找第一个数，就是子树的根节点 */
        int value = preorder[preLeft];
        TreeNode node = new TreeNode(value);
        int count = midLeft;

        /* 在中序遍历中找到位置并且计算长度 */
        while (inorder[count] != value) {
            count++;
        }
        count = count - midLeft;

        node.left = help(preorder, inorder, preLeft + 1, preLeft + count, midLeft, midLeft + count - 1);
        node.right = help(preorder, inorder, preLeft + count + 1, preRight, midLeft + count + 1, midRight);

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
