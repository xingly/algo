package linkedlist;

public class LRUBaseArray {

    private String[] data;

    private int n;

    private int size;

    public LRUBaseArray(int capacity) {
        this.data = new String[capacity];
        this.n = capacity;
    }

    /**
     * 访问元素
     *
     * @param value
     */
    public void offer(String value) {
        if (value == null) {
            throw new IllegalArgumentException("不支持访问null数据");
        }

        int index = find(value);
        if (index >= 0) {
            update(index, value);
        } else {
            if (size == n) {
                removeAndCache(value);
            } else {
                cache(value);
            }
        }
    }

    /**
     * 定位元素
     *
     * @param value
     * @return
     */
    public int find(String value) {
        for (int i = 0; i < n; i++) {
            if (value.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 更新元素
     *
     * @param index
     * @param value
     */
    private void update(int index, String value) {
        for (int i = index; i > 0; i--) {
            data[i] = data[i - 1];
        }
        data[0] = value;
    }

    /**
     * 删除并缓存
     *
     * @param value
     */
    private void removeAndCache(String value) {
        rightShift();
        data[0] = value;
    }

    /**
     * 缓存元素
     *
     * @param value
     */
    public void cache(String value) {
        rightShift();
        data[0] = value;
        size++;
    }

    /**
     * 右移一位
     */
    private void rightShift() {
        for (int i = size - 1; i >= 0; i--) {
            data[i + 1] = data[i];
        }
    }

    private void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUBaseArray lru = new LRUBaseArray(5);
        lru.offer("aa");
        lru.printAll();
        lru.offer("bb");
        lru.printAll();
        lru.offer("cc");
        lru.printAll();
        lru.offer("dd");
        lru.printAll();

        lru.offer("aa");
        lru.printAll();
    }
}
