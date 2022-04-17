package itAlgorithm.chapter_1_stack_list;

import java.util.Stack;

/**
 * 用一个栈帮助另一个栈排序
 */
public class StackHelpSort {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(4);
        stack.add(5);
        stack.add(2);
        stack.add(3);
        stack.add(1);
        stackSort(stack);
        System.out.println(stack);
    }

    public static void stackSort(Stack<Integer> stack) {
        if (stack.size() <= 1) return;
        Stack<Integer> helpStack = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!helpStack.isEmpty() && helpStack.peek() > cur) {
                stack.push(helpStack.pop());
            }
            helpStack.push(cur);
        }
        while (!helpStack.isEmpty()) {
            stack.push(helpStack.pop());
        }
    }
}
