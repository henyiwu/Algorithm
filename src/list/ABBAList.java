package list;

import java.util.Stack;

/**
 * 给定一个单链表的头结点，判断这个链表是不是回文结构
 * 例如
 * a -> b -> a
 * a -> b -> b -> a
 * 如果链表长度为n，时间复杂度达到O(n)，空间复杂度达到O(1)
 */
public class ABBAList {

    private static Node head = new Node(0);

    public static void main(String[] args) {
        initList();
        boolean b = isPalindrome2(head.next);
        System.out.println(b);
    }

    private static void printList() {
        Node tempCur = head.next;
        while (tempCur != null) {
            System.out.println("data:" + tempCur.data);
            tempCur = tempCur.next;
        }
    }

    private static void initList() {
//        for (int i = 0; i < 10; i++) {
//            Node temp = new Node(i);
//            if (i == 0) {
//                head.next = temp;
//                cur = head.next;
//            } else {
//                cur.setNextNode(temp);
//                cur = cur.next;
//            }
//        }
        Node node1 = new Node(1);
        head.next = node1;
        Node node2 = new Node(2);
        node1.next = node2;
        Node node3 = new Node(3);
        node2.next = node3;
        Node node4 = new Node(4);
        node3.next = node4;
        Node node5 = new Node(4);
        node4.next = node5;
        Node node6 = new Node(3);
        node5.next = node6;
        Node node7 = new Node(2);
        node6.next = node7;
        Node node8 = new Node(1);
        node7.next = node8;
    }

    /**
     * 简单做法，借助栈将链表逆序，额外空间复杂度O(n)
     *
     * @param head
     * @return
     */
    private static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (head != null) {
            if (head.data != stack.pop().data) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 高效的判断回文链表实现
     * 原理:先将后半部分链表反转，然后分别从头尾遍历，判断每个节点是否相等
     * 判断结束再恢复链表
     * @param head 第一个值节点
     */
    private static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 快慢指针n1是慢指针，n2是快指针
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        // 循环结束时
        // 链表长度为基数，n1会停在中点位置。
        // 链表长度为偶数，n1会停在中点靠左一个的位置，例如长度为6的链表，n1为2

        n2 = n1.next; // 中点右边第一个位置
        n1.next = null; // 断开左边最后一个节点的指向
        Node n3 = null; // 临时变量

        // n1 当前要指向的节点
        // n2 下一个要操作的节点
        // n3 临时变量
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }

        n3 = n1; // 保存最后一个节点
        n2 = head; // 保存第一个节点
        boolean res = true;

        // 判断是否是回文数
        while (n1 != null && n2 != null) {
            if (n1.data != n2.data) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        n1 = n3.next; // 最后一个节点的前一个节点
        n3.next = null; // 最后一个节点指向null

        // n3 要指向的目标节点
        // n1 当前操作的节点
        // n2 临时变量
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }

        return res;
    }
}