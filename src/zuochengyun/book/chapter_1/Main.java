package zuochengyun.book.chapter_1;

import java.util.Stack;

/**
 * 队列和栈
 */

public class Main {

    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();
        for (int i = 1; i < 10; i++) {
            queue.push(i);
        }
        System.out.println(queue.peek());
    }

}

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 *
 * 1.要求：pop、push、getMin 操作的时间复杂度是O(1)
 * 2.设计的栈类型可以使用线程的栈结构
 *
 * 难度：1
 */
class MyStack1 {
    private final Stack<Integer> stackData;
    private final Stack<Integer> stackMin;

    public MyStack1() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum) {
        stackData.push(newNum);
        if (stackMin.isEmpty() || this.getMin() >= newNum) {
            stackMin.push(newNum);
        }
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        int value = this.stackData.pop();
        if (value == this.getMin()) {
            stackMin.pop();
        }
        return value;
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        return this.stackMin.peek();
    }
}

class MyStack2 {
    final private Stack<Integer> stackData;
    final private Stack<Integer> stackMin;

    public MyStack2() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum) {
        if (stackMin.isEmpty() || stackMin.peek() >= newNum) {
            stackMin.push(newNum);
        } else {
            stackMin.push(stackMin.peek());
        }
        stackData.push(newNum);
    }

    public int pop() {
        stackMin.pop();
        return stackData.pop();
    }

    public int getMin() {
        return stackMin.peek();
    }
}

// *********************************************

/**
 * 用两个栈实现一个队列功能
 */
class TwoStackQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStackQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void push(int newNum) {
        stackPush.push(newNum);
    }

    public int pop() {
        if (stackPush.empty() && stackPush.empty()) {
            throw new RuntimeException("Your queue is empty");
        } else if (stackPop.isEmpty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek() {
        if (stackPush.empty() && stackPush.empty()) {
            throw new RuntimeException("Your queue is empty");
        } else if (stackPop.isEmpty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
}

// ********************************************

/**
 * 用递归函数逆序一个栈
 */
class ReverseStack {

    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.empty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }

        // 先执行这句的reverse会最后才执行stack.push(i)
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }
}

