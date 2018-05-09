package daily.mymap;

public class MyMap<K, V> {

    /**
     * 默认容量16
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    /**
     * 最大容量
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * resize的倍数
     */
    static final int EXPAND_RATE = 2;
    /**
     * 维护的数组
     */
    private transient Node<K, V>[] table;

    /**
     * Map的put操作
     *
     * @param key   key
     * @param value value
     * @return
     */
    public V put(K key, V value) {
        return this.putVal(hash(key), key, value);
    }

    private V putVal(int hash, K key, V value) {
        Node<K, V>[] temp;
        if ((temp = table) == null || table.length == 0) {
            this.resize();
        }
        return value;
    }

    /**
     * 扩充所要维护的数组
     *
     * @return
     */
    private Node<K, V>[] resize() {
        Node<K, V>[] oldNodes = table;
        int oldCap = oldNodes == null ? 0 : oldNodes.length;
        int newCap;
        if (oldCap > 0) {
            newCap = EXPAND_RATE * oldCap;
        } else {
            newCap = DEFAULT_INITIAL_CAPACITY;
        }

        int[] a = new int[10];

        Node<K, V>[] newNodes = (Node<K, V>[]) new Node[newCap];
        if (oldCap > 0) {
            for (int i = 0; i < oldCap; i++) {
                newNodes[i] = oldNodes[i];
            }
        } else {
            return newNodes;
        }
        return newNodes;

    }


    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
