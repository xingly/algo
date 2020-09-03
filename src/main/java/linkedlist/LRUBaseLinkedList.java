package linkedlist;

import java.util.Scanner;

/**
 * 基于单链表LRU算法
 */
public class LRUBaseLinkedList {

    /**
     * 默认链表容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 头结点
     */
    private Node head;

    /**
     * 链表长度
     */
    private int size;

    /**
     * 链表容量
     */
    private int capacity;

    public LRUBaseLinkedList() {
        this.head = new Node();
        this.size = 0;
        this.capacity = DEFAULT_CAPACITY;
    }

    public LRUBaseLinkedList(int capacity) {
        this.head = new Node();
        this.size = 0;
        this.capacity = capacity;
    }

    public void add(int data) {
        Node preNode = findPreNode(data);

        if (preNode == null) {
            if (size >= capacity) {
                deleteTail();
            }
            insertHead(data);
        } else {
            deleteByPreNode(preNode);
            insertHead(data);
        }

    }

    /**
     * 获取查找元素的前一个节点
     *
     * @param data
     * @return
     */
    private Node findPreNode(int data) {
        Node p = head;
        while (p.next != null) {
            if (p.next.data == data) {
                return p;
            }
            p = p.next;
        }

        return null;
    }

    /**
     * 删除preNode节点下一个节点
     *
     * @param preNode
     */
    private void deleteByPreNode(Node preNode) {
        preNode.next = preNode.next.next;
        size--;
    }

    /**
     * 链表头插入节点
     *
     * @param data
     */
    private void insertHead(int data) {
        Node next = head.next;
        Node p = new Node(data, next);
        head.next = p;
        size++;
    }

    /**
     * 删除尾结点
     */
    private void deleteTail() {
        Node cur = head;
        Node pre = null;

        if (cur.next == null) {
            return;
        }

        while (cur.next != null) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;

        size--;
    }

    /**
     * 打印链表
     */
    private void printAll() {
        Node node = head.next;
        if (node != null) {
            System.out.print(node.data);
            while (node.next != null) {
                System.out.print("->" + node.next.data);
                node = node.next;
            }
            System.out.println();
        }
    }

    private static class Node {
        private int data;
        private Node next;

        public Node() {
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRUBaseLinkedList list = new LRUBaseLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }
}
