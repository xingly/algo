package heap;

public class Heap {

    private int[] a; // 数组，从下标 1 开始存储数据
    private int n; // 堆可以存储的最大数据个数
    private int count; // 堆中已存储的数据个数

    public Heap(int capacity) {
        a = new int[capacity + 1];
        this.n = capacity;
        this.count = 0;
    }

    /**
     * 插入
     * @param data
     */
    public void insert(int data) {
        if (count >= n) {
            return;
        }

        ++count;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            swap(a, i, i/2);
            i = i/2;
        }
    }

    /**
     * 删除堆顶元素
     */
    public void removeMax() {
        if (count == 0) {
            return;
        }

        a[1] = a[count];
        --count;

        heapify(a, count, 1);
    }

    /**
     * 自上而下堆化
     * @param a
     * @param n
     * @param i
     */
    private void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

