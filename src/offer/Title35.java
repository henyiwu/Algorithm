package offer;

/*
请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。

示例 1：
输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]

示例 2：
输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]

示例 3：
输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]

示例 4：
输入：head = []
输出：[]
解释：给定的链表为空（空指针），因此返回 null。

提示：

-10000 <= Node.val <= 10000
Node.random为空（null）或指向链表中的节点。
节点数目不超过 1000 。
 */
public class Title35 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    static class Solution {
        public Node copyRandomList(Node head) {
            Node temp = head;
            Node newHead = new Node(0);
            Node newFirstNode = newHead;
            while (temp != null) {
                newFirstNode.next = new Node(temp.val);
                newFirstNode = newFirstNode.next;
                temp = temp.next;
            }
            // 至此链表除随机指针外复制完成

            Node cur = newHead.next;
            Node originalHead = head;
            while (cur != null) {
                int random;
                if (originalHead.random == null) {
                    random = -1;
                } else {
                    random = getIndexByRandom(originalHead.random, head);
                }
                copyRandom(cur, newHead.next, random);
                cur = cur.next;
                originalHead = originalHead.next;
            }
            return newHead.next;
        }

        private int getIndexByRandom(Node random, Node head) {
            if (random == null) {
                return -1;
            }
            Node cur = head;
            int index = 0;
            while (cur != random) {
                index++;
                cur = cur.next;
            }
            return index;
        }

        private void copyRandom(Node node, Node head, int target) {
            Node cur = head;
            if (target == -1) {
                return;
            }
            for (int i = 0; i < target; i++) {
                cur = cur.next;
            }
            node.random = cur;
        }
    }

    public static void main(String[] args) {
        // Random pointer of node with val 13 points to a node not in the copied list
        // [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node node0 = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        node0.random = null;
        node1.random = node0;
        node2.random = node4;
        node3.random = node2;
        node4.random = node0;
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Solution solution = new Solution();
        solution.copyRandomList(node0);
    }
}
