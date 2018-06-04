package f_08_hash;

import java.util.LinkedList;

/**
 *
 * @author tiago
 */
public class HashtableBucket <K, V> {
    
    private LinkedList<Entry<K,V>>[] table;
    private int size;   // Bucket size
    
    private static class Entry <K, V> {
        public K key;
        public V value;
        public Entry(K k, V v) {
            key = k;
            value = v;
        }
    }
    
    public HashtableBucket(int size) {
        this.size = size;
        table = new LinkedList[size];
    }
    
    private int getIndex(K key) {
        int index = key.hashCode() % table.length;
        return index < 0? index + table.length: index;
    }
    
    public V put(K key, V value) {
        int index = getIndex(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        } 
        for (Entry<K, V> e: table[index]) {
            if (e.key.equals(key)) {
                V oldValue = e.value;
                e.value = value; 
                return oldValue;
            }
        }
        table[index].add(new Entry(key, value));
        return null;
    }
    
    public V get(K key) {
        int index = getIndex(key);
        if (table[index] == null) 
            return null;
        for (Entry<K, V> e: table[index]) 
            if (e.key.equals(key)) 
                return e.value;
        return null;
    }
    
    public V  remove(K key) {
        int index = getIndex(key);
        if (table[index] == null) 
            return null;
        V oldValue;
        for (Entry<K, V> e: table[index]) 
            if (e.key.equals(key)) {
                oldValue = e.value;
                table[index].remove(e);
                return oldValue;
            }
        return null;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< size; i++) {
            if (table[i] != null) {
                for (Entry<K, V> e : table[i]) {
                    if (e.value != null) {
                        sb.append(i).append(":").append(e.value);
                        sb.append("\n");
                    }
                }
            }
        }
        return sb.toString();
    }
}
