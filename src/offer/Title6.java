package offer;

import java.util.Arrays;

/**
 * 从尾到头打印链表
 * <p>
 * 直观解法：压栈
 */
public class Title6 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        int[] ints = reversePrint(listNode1);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 高效解法：
     * 1. 先确定数组大小
     * 2. 遍历链表，把数值从后向钱往数组填充
     */
    public static int[] reversePrint(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        int[] arr = new int[size];
        temp = head;
        for (int i = size - 1; i >= 0; i--) {
            arr[i] = temp.val;
            temp = temp.next;
        }
        return arr;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}