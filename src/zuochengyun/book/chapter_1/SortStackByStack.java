package zuochengyun.book.chapter_1;

import java.util.Stack;

/**
 * 一个栈中元素的类型为整型，现在想将该栈从顶到底按大到小的顺序排序，只允许申请一个栈，
 * 可以申请新的变量
 */
public class SortStackByStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(5);
        stack.push(14);
        stack.push(4);
        stack.push(44);
        stack.push(24);
        stack.push(54);
        stack.push(24);
        stack.push(477);
        stack.push(54);

        sortStackByStack(stack);
        System.out.println(stack.toString());
    }

    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> helpStack = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!helpStack.isEmpty() && helpStack.peek() < cur) {
                stack.push(helpStack.pop());
            }
            helpStack.push(cur);
        }
        while (!helpStack.isEmpty()) {
            stack.push(helpStack.pop());
        }
    }
}
