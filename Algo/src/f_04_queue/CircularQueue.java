package f_04_queue;

public class CircularQueue<E> {
    private static int DEFAULT_CAP = 5;
    private int cap = DEFAULT_CAP;
    private E[] e = (E[]) new Object[cap];
    private int size;
    private int head; // first position
    private int tail; // last position 
    
    private boolean expandCondition() {
        return size >= cap - 1;
    }
    private boolean shrinkCondition() {
        return size == cap/4 && size > 1;
    }
    public void reallocate(int newSize) {
        cap = newSize;
        E[] temp = (E[]) new Object[cap];
        int h= head;
        for (int i = 0; i < size; i++) {
            temp[i] = e[h];
            h = ++h % cap;
        }
        head = 0;
        tail = size - 1;
        temp = e;
    }
    public void offer(Object o) {
        if (expandCondition())
            reallocate(cap*2);
        e[tail] = (E) o;
        tail = ++tail % cap;
        size++;
    }
    public Object poll() {
        Object o = e[head];
        e[head] = null;
        head = ++head % cap;
        size--;
        if (shrinkCondition())
            reallocate(cap/2);
        return o;
    }
    public Object peek() {
        return e[head];
    }
    public boolean isEmpty() {
        return size == 0;
    }
     public int size() {
       return size;
    }
     
    @Override
     public String toString() {
       StringBuilder sb = new StringBuilder("");
       for (int i = 0, h = head; i < size; i++) {
            sb.append("[").append(e[h]).append("]");
           h = ++h % cap;
       }
       return sb.toString();
     }
}
