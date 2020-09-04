package linkedlist;

/**
 * 1. 单链表反转
 * 2. 链表中环的检测
 * 3. 两个有序链表合并
 * 4. 删除链表倒数第 n 个结点
 * 5. 求链表中间节点
 * 6. 单链表插入、删除、查找操作
 */
public class SinglyLinkedList {

    private Node head;

    public SinglyLinkedList() {
        head = new Node(0, null);
    }

    /**
     * 单链表反转
     *
     * @param list
     * @return
     */
    public Node reverse(Node list) {
        Node cur = list;
        Node pre = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 检测环
     *
     * @param list
     * @return
     */
    public boolean checkCircle(Node list) {
        Node fast = list;
        Node slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    /**
     * 有序链表合并
     *
     * @param list1
     * @param list2
     * @return
     */
    public Node mergeTwoLists(Node list1, Node list2) {
        Node head = new Node(0, null);
        Node p = head;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }

        p.next = list1;
        if (list1 == null) {
            p.next = list2;
        }

        return head.next;
    }

    /**
     * 删除链表第 k 个节点
     *
     * @param list
     * @param k
     * @return
     */
    public Node deleteKth(Node list, int k) {

        Node pre = null;
        Node cur = list;
        int i = 1;
        while (cur != null && i < k) {
            pre = cur;
            cur = cur.next;
            i++;
        }

        if (cur == null) {
            return list;
        }

        if (pre == null) {
            list = list.next;
        } else {
            pre.next = pre.next.next;
        }
        return list;
    }

    /**
     * 删除链表倒数第 k 个节点
     *
     * @param list
     * @param k
     * @return
     */
    public Node deleteLastKth(Node list, int k) {
        Node fast = list;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            i++;
        }

        if (fast == null) {
            return list;
        }

        Node pre = null;
        Node slow = list;
        while (fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }

        if (pre == null) {
            list = list.next;
        } else {
            pre.next = pre.next.next;
        }

        return list;
    }

    /**
     * 求中间节点
     *
     * @param list
     * @return
     */
    public Node findMiddleNode(Node list) {
        Node slow = list;
        Node fast = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    /**
     * 从尾到头打印链表
     *
     * @param list
     */
    public static void printFromTail(Node list) {
        if (list != null) {
            if (list.next != null) {
                printFromTail(list.next);
            }
            System.out.print(list.data + " ");
        }
    }

    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private SinglyLinkedList addNode(int data) {
        Node node = new Node(data, null);
        node.next = head.next;
        head.next = node;
        return this;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addNode(1).addNode(2).addNode(3);

        System.out.println("从头到尾打印链表");
        Node node = list.head.next;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();

        System.out.println("从尾到头打印链表");
        printFromTail(list.head.next);
    }
}
