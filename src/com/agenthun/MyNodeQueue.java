package com.agenthun;

/**
 * Created by Agent Henry on 2015/7/27.
 */
public class MyNodeQueue<E> {
    private Node<E> head = null;
    private Node<E> tail = null;

    public boolean isEmpty() {
        return head == tail;
    }

    public void push(E data) {
        Node<E> newNode = new Node<>(data);
        if (head == null && tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public E pop() {
        if (isEmpty()) return null;
        E data = head.data;
        head = head.next;
        return data;
    }

    public int size() {
        Node<E> temp = head;
        int n = 0;
        while (temp != null) {
            temp = temp.next;
            n++;
        }
        return n;
    }

    public static void main(String[] args) {
        MyNodeQueue<Integer> q = new MyNodeQueue<>();
        q.push(1);
        q.push(2);
        q.push(4);
        q.push(3);
        System.out.println("队列元素个数 = " + q.size());
        System.out.println("队列首元素 =" + q.pop());
        System.out.println("队列首元素 =" + q.pop());
    }
}

class Node<E> {
    Node<E> next = null;
    E data;

    public Node(E data) {
        this.data = data;
    }
}
