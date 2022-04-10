package list;

public class ReverseList {
    public static void main(String[] args) {

        Node head = new Node(0);
        Node temp = null;
        Node cur = null;
        for (int i = 1; i < 10; i++) {
            temp = new Node(i);
            if (i == 1)
                head.setNextNode(temp);
                //temp = new Node(i);
            else
                cur.setNextNode(temp);
            cur = temp;
        }

        temp = head;
        while (temp != null) {
            System.out.print(temp.getData() + ",");
            temp = temp.getNextNode();
        }
        head = reverse2(head);
        System.out.println("");
        System.out.println("*********************");
        while (head != null) {
            System.out.print(head.getData() + ",");
            head = head.getNextNode();
        }
    }

    /**
     * 递归反转链表
     * @param head
     * @return
     */
    public static Node reverse(Node head) {
        if (head == null || head.getNextNode() == null)
            return head;
        Node reverseHead = reverse(head.getNextNode());
        head.getNextNode().setNextNode(head);
        head.setNextNode(null);
        return reverseHead;
    }

    /**
     * 循环反转链表
     * 1 -> 2 -> 3 -> 4
     * null <- 1      2 ->3 -> 4
     */
    public static Node reverse2(Node head) {
        if (head == null || head.getNextNode() == null)
            return head;
        Node pre = null;
        Node next = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    public void setNextNode(Node next) {
        this.next = next;
    }

    public Node getNextNode() {
        return next;
    }

    public int getData() {
        return data;
    }
}