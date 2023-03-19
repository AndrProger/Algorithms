package HashMap;

public class HashMapNode<K,V> {
    private K key;
    private V value;
    private HashMapNode nextNode=null;

    private int hash=-1;
    protected HashMapNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int hashCode() {
        if(hash==-1) return hash= key.hashCode();
        else return  hash;

    }

    @Override
    public String toString() {
        return "{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public HashMapNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(HashMapNode nextNode) {
        this.nextNode = nextNode;
    }
}
