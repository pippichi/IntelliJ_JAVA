package 自己写的栈_涉及到双端队列;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack<E> {
    private int capacity;
    private Deque<E> deque = new ArrayDeque<>();

    public MyStack(int capacity) {
        super();
        this.capacity = capacity;
    }

    public boolean push(E e){
        if(deque.size()+1>capacity){
            return false;
        }
        return deque.offerLast(e);
    }

    public E pop(){
        return deque.pollLast();
    }

    public E peek(){
        return deque.peekLast();
    }
    public int size(){
        return deque.size();
    }
}
