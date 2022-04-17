package itAlgorithm.chapter_1_stack_list;

import java.util.Stack;

/**
 * 两个栈组成的队列
 * 1. 两个栈一个叫push栈，一个叫pop栈
 * 2. 向队列添加数据时，压入push栈
 * 3. 出队或者取队头数据时，如果pop栈为空，先把push栈数据压入pop栈，否则pop栈弹出一个元素
 */
public class TwoStackQueue {

    private Stack<Integer> pushStack = new Stack<>();
    private Stack<Integer> popStack = new Stack<>();

    public void add(int value) {
        pushStack.add(value);
    }

    public int poll() throws Exception {
        if (pushStack.isEmpty() && popStack.isEmpty()) {
            throw new Exception("queue is empty");
        } else if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    public int peek() throws Exception {
        if (pushStack.isEmpty() && popStack.isEmpty()) {
            throw new Exception("queue is empty");
        } else if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    @Override
    public String toString() {
        return "TwoStackQueue{" +
                "pushStack=" + pushStack +
                ", popStack=" + popStack +
                '}';
    }

    public static void main(String[] args) throws Exception {
        TwoStackQueue queue = new TwoStackQueue();
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.add(100);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
