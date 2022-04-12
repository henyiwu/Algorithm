package itAlgorithm.chapter_1_stack_list;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("栈反转前"+stack.toString());
        reverse(stack);
        System.out.println("栈反转后"+stack.toString());
    }

    /**
     * 删除栈底元素并返回
     * @param stack
     * @return
     */
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int last = stack.pop();
        if (stack.isEmpty()) {
            return last;
        } else {
            int lastElement = getAndRemoveLastElement(stack);
            stack.push(last);
            return lastElement;
        }
    }

    /**
     * 反转栈入口
     * @param stack
     */
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int last = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(last);
    }
}