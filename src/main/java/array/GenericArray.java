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
     * 查看数组是否包含元素e
     *
     * @param e
     * @return
     */
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取回应元素的下标
     *
     * @param e
     * @return
     */
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 在索引处添加元素
     *
     * @param index
     * @param e
     */
    public void add(int index, T e) {
        checkIndexForAdd(index);

        // 元素个数等于数组长度，扩容为原数组2倍
        if (size == data.length) {
            resize(2 * size);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 向数组头插入元素
     *
     * @param e
     */
    public void addFirst(T e) {
        add(0, e);
    }

    /**
     * 向数组尾插入元素
     *
     * @param e
     */
    public void addLast(T e) {
        add(size, e);
    }

    /**
     * 删除索引处元素
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        checkIndex(index);

        T ret = data[index];
        for (int i = index; i < size; i++) {
            data[index] = data[index + 1];
        }

        data[size] = null;
        size--;

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ret;
    }

    /**
     * 删除第一个元素
     *
     * @return
     */
    public T removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     *
     * @return
     */
    public T removeLast() {
        return remove(size - 1);
    }

    public void remove(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 扩容数组
     *
     * @param capacity
     */
    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 索引检查 - set、get
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

    /**
     * 索引检查 - add
     *
     * @param index
     * @return
     */
    private boolean checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add fail, index must >=0 and <= size");
        }
        return true;
    }
}
