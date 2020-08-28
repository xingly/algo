package linkedlist;

/**
 * 1. 单链表反转
 * 2. 链表中环的检测
 * 3. 两个有序链表合并
 * 4. 删除链表第 n 个节点
 * 5. 求链表中间节点
 */
public class SinglyLinkedList {

    /**
     * 链表反转
     *
     * @param p
     * @return
     */
    public Node reverse(Node p) {
        Node cur = p;
        Node pre = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

    public static void main(String[] args) {
        Node node1 = new Node(1, null);
        Node node2 = new Node(1, null);
        System.out.println(node1 == node2);
    }

}
