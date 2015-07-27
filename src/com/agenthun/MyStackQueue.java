package com.agenthun;

import java.util.Stack;

/**
 * Created by Agent Henry on 2015/7/27.
 */
public class MyStackQueue<E> {
    private Stack<E> s1 = new Stack<>();
    private Stack<E> s2 = new Stack<>();

    public synchronized void push(E e) {
        s1.push(e);
    }

    public synchronized E pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) s2.push(s1.pop());
        }
        return s2.pop();
    }

    public synchronized boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {
        MyStackQueue<Integer> q = new MyStackQueue<>();
        q.push(1);
        q.push(3);
        System.out.println("队列首元素 = " + q.pop());
        System.out.println("队列首元素 = " + q.pop());
    }
}
