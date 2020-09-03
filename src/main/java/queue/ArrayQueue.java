package queue;

/**
 * 基于数组实现的队列
 */
public class ArrayQueue {

    // 数组
    private String[] items;
    // 数组长度
    private int n;
    // 队头
    private int head = 0;
    // 队尾
    private int tail = 0;

    public ArrayQueue(int capacity) {
        this.items = new String[capacity];
        this.n = capacity;
    }

    /**
     * 入队
     *
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        if (tail == n) {
            return false;
        }
        items[tail] = item;
        tail++;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public String dequeue() {
        if (head == tail) {
            return null;
        }
        return items[head++];
    }

    private void printAll() {
        int i = head;
        while (i < tail) {
            System.out.print(items[i] + " ");
            i++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        System.out.println("入队");
        queue.enqueue("aa");
        queue.printAll();
        queue.enqueue("bb");
        queue.printAll();
        queue.enqueue("cc");
        queue.printAll();

        System.out.println("出队");
        queue.dequeue();
        queue.printAll();
        queue.dequeue();
        queue.printAll();
    }

}
