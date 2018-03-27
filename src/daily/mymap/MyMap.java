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
     * 维护的数组
     */
    private transient Node<K, V>[] table;

    /**
     * Map的put操作
     * @param key key
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
     * @return
     */
    private Node<K, V>[] resize() {
        Node<K, V>[] oldNodes = table;

        return oldNodes;

    }


    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
