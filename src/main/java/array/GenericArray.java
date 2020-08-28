package array;

/**
 * 动态扩容的数组
 *
 * @param <T>
 */
public class GenericArray<T> {
    private T[] data;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public GenericArray() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取数组元素个数
     */
    public int count() {
        return size;
    }

    /**
     * 判读数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 修改 index 位置元素
     *
     * @param index
     * @param e
     */
    public void set(int index, T e) {
        checkIndex(index);
        data[index] = e;
    }

    /**
     * 获取 index 位置的元素
     *
     * @param index
     * @return
     */
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    /**
     * 索引检查
     *
     * @param index
     * @return
     */
    private boolean checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index must >= 0 and < size.");
        }
        return true;
    }
}
