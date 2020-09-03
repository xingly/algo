package stack;

/**
 * 基于链表实现的栈
 */
public class LinkedListStack {

    private Node top;

    /**
     * 进栈
     *
     * @param data
     */
    public void push(String data) {
        Node node = new Node(data, null);
        if (top == null) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }
    }

    /**
     * 出栈
     *
     * @return
     */
    public String pop() {
        if (top == null) {
            return null;
        }
        String data = top.data;
        top = top.next;
        return data;
    }

    /**
     * 打印
     */
    private void printAll() {
        Node p = top;
        while (p != null) {
            System.out.print(p.data + ",");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        stack.push("aa");
        stack.printAll();
        stack.push("bb");
        stack.printAll();
        stack.push("cc");
        stack.printAll();
        stack.push("dd");
        stack.printAll();

        System.out.println("出栈：" + stack.pop());
        stack.printAll();
    }
}
