package com.turbo.test.other;

import org.junit.Test;

import java.util.Stack;

/**
 * 用栈来实现队列
 */
public class Queue {
    private Stack<Integer> stackPush;

    private Stack<Integer> stackPop;

    public Queue() {
        this.stackPush = new Stack<Integer>();
        this.stackPop = new Stack<Integer>();
    }

    public void add(int e) {
        this.stackPush.push(e);
    }

    public int poll() {
        tranfer();
        return this.stackPop.pop();
    }

    public int peek() {
        tranfer();
        return this.stackPop.peek();
    }

    private void tranfer() {
        if (this.stackPop.empty()) {
            if (this.stackPush.isEmpty()) { // isEmpty是Stack继承的Vector的方法
                throw new RuntimeException("Your queue is empty.");
            }
            while (!this.stackPush.empty()) { // empty是Stack自带的方法
                this.stackPop.push(this.stackPush.pop());
            }
        }
    }

    /////// 测试方法//////
    @Test
    public void test() {
        Queue queue = new Queue();
        queue.add(1);
        queue.add(2);
        queue.add(6);
        queue.add(3);
        queue.add(4);
//        System.out.println("peek:" + queue.peek());
        System.out.println(queue.poll());
        queue.add(5);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        Queue queue1 = new Queue();
//        queue1.peek(); // java.lang.RuntimeException: Your queue is empty.
        char a = (char)Integer.valueOf("21378").intValue();
        System.out.println("====="+String.valueOf(a));
        String result = "（  ）们".replaceAll("\\（.+\\）", "（你）").replace("\\（.+\\）", "（你）");
        System.out.println("====="+result);
    }
}
