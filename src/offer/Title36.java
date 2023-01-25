package offer;

import java.util.ArrayList;

/*
剑指 Offer 36. 二叉搜索树与双向链表
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。

为了让您更好地理解问题，以下面的二叉搜索树为例：

我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。
对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。

下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。

特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，
树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 */
public class Title36 {

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    static class Solution {
        public Node treeToDoublyList(Node root) {
            if (root == null) return null;
            ArrayList<Node> arrayList = new ArrayList<>();
            dfs(root, arrayList);
            for (int i = 0; i < arrayList.size() - 1; i++) {
                Node cur = arrayList.get(i);
                Node next = arrayList.get(i + 1);
                cur.right = next;
                next.left = cur;
            }
            Node first = arrayList.get(0);
            Node last = arrayList.get(arrayList.size() - 1);
            first.left = last;
            last.right = first;
            return first;
        }

        private void dfs(Node root, ArrayList<Node> arrayList) {
            if (root == null) {
                return;
            }
            dfs(root.left, arrayList);
            arrayList.add(root);
            dfs(root.right, arrayList);
        }
    }

    public static void main(String[] args) {
        /*
            [4,2,5,1,3]

                    4
                   2 5
                  1 3
         */

        Solution solution = new Solution();
        Node node1 = new Node(4);
        Node node2 = new Node(2);
        Node node3 = new Node(5);
        Node node4 = new Node(1);
        Node node5 = new Node(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        Node node = solution.treeToDoublyList(node1);
        System.out.println(node);
    }
}
