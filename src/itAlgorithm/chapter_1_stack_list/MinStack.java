package itAlgorithm.chapter_1_stack_list;

import java.util.Stack;

/**
 * 设计一个有getMin功能的栈
 * 实现一个特殊的栈，在实现栈的基本功能上，再实现返回栈中最小元素的操作
 *
 * 要求：
 * 1. pop、push、getMin操作的时间复杂度都是O（1）
 * 2. 设计的栈类型可以使用现成的栈结构
 */

/**
 * 牺牲了时间，节省了空间
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack_2 minStack = new MinStack_2();
        minStack.push(44);
        minStack.push(31);
        minStack.push(31);
        minStack.push(14);
        minStack.push(43);
        System.out.println(minStack.getMin());
        minStack.push(2);
        System.out.println(minStack.getMin());
    }

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MinStack() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int data) {
        dataStack.push(data);
        if (minStack.isEmpty() || minStack.peek() >= data) {
            minStack.push(data);
        }
    }

    public int pop() {
        int data = dataStack.pop();
        if (data == getMin()) {
            this.minStack.pop();
        }
        return data;
    }

    public int getMin() {
        return this.minStack.peek();
    }
}

/**
 * 牺牲了空间，省了时间
 */
class MinStack_2 {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MinStack_2() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    /**
     * 不用比较minStack，如果当前值大于minStack最小值，继续向minStack压入最小值
     * @param data
     */
    public void push(int data) {
        dataStack.push(data);
        if (minStack.isEmpty()) {
            minStack.push(data);
        } else if (minStack.peek() >= data){
            minStack.push(data);
        } else {
            minStack.push(getMin());
        }
    }

    public int pop() {
        int data = dataStack.pop();
        this.minStack.pop();
        return data;
    }

    public int getMin() {
        return this.minStack.peek();
    }
}