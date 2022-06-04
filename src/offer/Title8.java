package offer;

/**
 * 二叉树的下一个节点
 * 给定一棵二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？树中的节点除了有两个分别指向左、
 * 右子节点的指针，还有一个指向父节点的指针
 */
public class Title8 {
    public static void main(String[] args) {

    }

    public TreeNode8 inorderSuccessor(TreeNode8 treeNode) {
        // 中序遍历的特点 左根右
        // 一个节点，有右子树，一定返回右子树最左边节点
        if (treeNode.right != null) {
            treeNode = treeNode.right;
            while (treeNode.left != null) {
                treeNode = treeNode.left;
            }
            return treeNode;
        }

        // 没有右子树，返回父亲节点
        while (treeNode.father != null) {
            if (treeNode == treeNode.father.left) { // 当前节点是父节点的左节点
                return treeNode.father;
            }
            treeNode = treeNode.father;
        }

        return null;
    }
}

class TreeNode8 {
    int val;
    TreeNode8 left;
    TreeNode8 right;
    TreeNode8 father;

    TreeNode8(int x) {
        this.val = x;
    }
}
