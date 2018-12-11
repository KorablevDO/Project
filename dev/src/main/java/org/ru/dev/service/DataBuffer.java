package org.ru.dev.service;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DataBuffer<T> {
    private int limit = 0;
    private Deque<T> deque;

    public DataBuffer(){
        this.deque = new LinkedList<>();
    }

    public DataBuffer(int limit){
        this.deque = new ArrayDeque<>(limit);
        this.limit = limit;
    }

    public int getLimit(){
        return this.limit;
    }

    public void set(T t){
        this.deque.addLast(t);
    }

    public T get(){
        return this.deque.getFirst();
    }
}
