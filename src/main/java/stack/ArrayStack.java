package stack;

/**
 * 基于数组实现的顺序栈
 */
public class ArrayStack {

    private String[] items; // 数组
    private int n; // 栈大小
    private int size; // 栈中元素个数

    public ArrayStack(int n) {
        this.items = new String[n];
        this.n = n;
        this.size = 0;
    }

    /**
     * 入栈操作
     *
     * @param item
     * @return
     */
    public boolean push(String item) {
        // 栈满
        if (size == n) {
            return false;
        }
        items[size] = item;
        size++;
        return true;
    }

    /**
     * 出栈操作
     *
     * @return
     */
    public String pop() {
        // 栈空
        if (size == 0) {
            return null;
        }
        String temp = items[size - 1];
        size--;
        return temp;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);
        stack.push("aa");
        stack.push("bb");
        stack.push("cc");
        stack.push("dd");

        System.out.println(stack.pop());
    }
}
