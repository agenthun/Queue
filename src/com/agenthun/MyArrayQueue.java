package com.agenthun;

import java.util.LinkedList;

/**
 * Created by Agent Henry on 2015/7/27.
 */
public class MyArrayQueue<E> {
    private LinkedList<E> list = new LinkedList<>();
    private int size = 0;

    public synchronized void push(E e) {
        list.addLast(e);
        size++;
    }

    public synchronized E pop() {
        size--;
        return list.removeFirst();
    }

    public synchronized boolean isEmpty() {
        return size == 0;
    }

    public synchronized int size() {
        return size;
    }

    public static void main(String[] args) {
        MyArrayQueue<Integer> q = new MyArrayQueue<>();
        q.push(1);
        q.push(2);
        q.push(4);
        q.push(3);
        System.out.println("队列元素个数 = " + q.size());
        System.out.println("队列首元素 =" + q.pop());
        System.out.println("队列首元素 =" + q.pop());
    }
}
