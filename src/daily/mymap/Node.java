package daily.mymap;

import java.util.Objects;

public class Node<K, V> {

    private final int hash;

    private final K key;

    private V value;

    private Node next;

    Node(int hashcode, V v, K k, Node<K, V> next) {
        this.hash = hashcode;
        this.key = k;
        this.value = v;
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public final V setValue(V newV) {
        V old = value;
        value = newV;
        return old;
    }

    @Override
    public String toString() {
        return this.key + ": " + this.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj
                || obj instanceof Node
                && ((Node) obj).getKey().equals(this.key)
                && ((Node) obj).getValue().equals(this.value)
                && obj.hashCode() == this.hash;

    }
}
