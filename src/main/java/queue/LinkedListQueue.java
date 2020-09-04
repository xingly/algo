package queue;

import stack.LinkedListStack;

/**
 * 基于链表实现的队列
 */
public class LinkedListQueue {

    private Node head; // 队头
    private Node tail; // 队尾

    /**
     * 入队
     *
     * @param data
     */
    public void enqueue(String data) {
        if (tail == null) {
            Node node = new Node(data);
            head = node;
            tail = node;
        } else {
            tail.next = new Node(data);
            tail = tail.next;
        }
    }

    /**
     * 出队
     *
     * @return
     */
    public String dequeue() {
        if (head == null) {
            return null;
        }
        String data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }

    /**
     * 打印
     */
    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node {
        private String data;

        private Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue("aaa");
        queue.printAll();
        queue.enqueue("bbb");
        queue.printAll();
        queue.enqueue("ccc");
        queue.printAll();
        queue.dequeue();
        queue.printAll();
        queue.dequeue();
        queue.printAll();
    }
}