package f_08_hash;

import java.util.LinkedList;

/**
 *
 * @author tiago
 */
public class HashtableArray <K, V> {
    
    private static int size = 10;
    private static int arr_cap = 300;
    private Entry<K, V>[][] table = new Entry[size][arr_cap];

    private int[] t_size = new int[size];
    
    public static class Entry<K, V> {
        K key;
        V value;
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    } 
    
    public HashtableArray(int max) {
        size = max;
    }
    
    private int index(K key) {
        int i = key.hashCode() % size;
        if (i < 0) i += size;
        return i;
    }
    
    public Object put(K key, V value) {
        int index = index(key);
        for (Entry<K, V> e: table[index]) {
            if (e == null) break;
            Object oldValue = e.value;
            e.value = value;
            return oldValue;
        }
        table[index][t_size[index]++] = new Entry(key, value);
        return null;
    }
    
   @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (Entry<K, V> e : table[i]) {
                if (e == null) break;
                sb.append(i).append(":").append(e.value).append("\n");
            }
        }       
        return sb.toString();
    }
}
