package f_04_queue;


public interface QueueInt {
    public void offer(Object o);
    public Object poll();
    public Object peek();
    public boolean isEmpty();
    public int size();
}
