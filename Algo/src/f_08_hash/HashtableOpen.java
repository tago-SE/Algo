package f_08_hash;

/**
 *
 * @author tiago
 */
public class HashtableOpen<K, V> {
    private int cap = 117;
    
    private Entry<K, V>[] e = new Entry[cap];
    
    private static class Entry<K, V> {
        private K key;
        private V value;
        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private int index(K key) {
        int i = key.hashCode() % e.length;
        if (i < 0) 
            i = (i + cap) % cap;
        return i;
    }
    
    public void put(K key, V value) {
        if (key == null) throw new NullPointerException();
        int i = index(key);
        while (e[i] != null) 
            i = ++i % e.length;
        e[i] = new Entry(key, value);
    }
    
    public boolean exist(K key){
        if (key == null) throw new NullPointerException();
        int i = index(key);
        while (e[i] != null) {
            if (e[i].key.equals(key)) 
                return true;
            i = ++i % e.length;
        }
        return false;
    }
       
}
