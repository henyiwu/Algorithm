package offer;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 */
public class Title22 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode kthFromEnd = getKthFromEnd2(listNode1, 2);
        System.out.println(kthFromEnd.val);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 1 2 3 4 5
    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        int target = len - k + 1;
        for (int i = 0; i < target - 1; i++) {
            head = head.next;
        }
        return head;
    }

    /**
     * 辅助指针
     * 用一个辅助指针记录长度，作为遍历的条件，对结果指针进行操作
     */
    public static ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode help = head, latter = head;
        for (int i = 0; i < k; i++) {
            help = help.next;
        }
        while (help != null) {
            help = help.next;
            latter = latter.next;
        }
        return latter;
    }
}