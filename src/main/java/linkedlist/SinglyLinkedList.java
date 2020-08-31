package linkedlist;

/**
 * 1. 单链表反转
 * 2. 链表中环的检测
 * 3. 两个有序链表合并
 * 4. 删除链表倒数第 n 个结点
 * 5. 求链表中间节点
 */
public class SinglyLinkedList {

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
            cur = cur.next;
            pre = cur;
            i++;
        }

        if (cur == null) {
            return list;
        }

        pre.next = pre.next.next;
        cur = null;

        return list;
    }

    /**
     * 删除链表倒数第 n 个节点
     *
     * @param list
     * @param n
     * @return
     */
    public Node deleteLastKth(Node list, int n) {

        if (n < 1 || list == null) {
            return null;
        }

        Node pre = null;
        Node p = list;
        int i = 0;
//        while (p != null) {
//            pre = p;
//            p = p.next;
//            i++;
//            if(i )
//        }


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
