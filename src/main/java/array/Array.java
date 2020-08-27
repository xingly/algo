package array;

import java.util.Arrays;

/**
 * 数组插入、删除、随机访问
 */
public class Array {

    private int[] data;

    private int n;

    private int count;

    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    /**
     * 根据索引找到数组中元素并返回
     *
     * @param index
     * @return
     */
    public int find(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }
        return data[index];
    }

    /**
     * 插入元素
     *
     * @param index
     * @param value
     * @return
     */
    public boolean insert(int index, int value) {
        // 数组已满
        if (count == n) {
            return false;
        }

        // 位置不合法
        if (index < 0 || index > count) {
            return false;
        }

        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        count++;
        return true;
    }

    /**
     * 根据索引，删除数组中元素
     *
     * @param index
     * @return
     */
    public boolean delete(int index) {
        if (index < 0 || index >= count) {
            return false;
        }

        for (int i = index; i <= count - 1; i++) {
            data[i] = data[i + 1];
        }
        count--;
        return true;
    }

    public static void main(String[] args) {
        Array array = new Array(10);
        array.insert(0, 1);
        array.insert(0, 2);
        array.insert(0, 3);
        array.insert(0, 4);
        System.out.println(Arrays.toString(array.data));
        System.out.println(array.count);
        System.out.println(array.data.length);
    }
}
