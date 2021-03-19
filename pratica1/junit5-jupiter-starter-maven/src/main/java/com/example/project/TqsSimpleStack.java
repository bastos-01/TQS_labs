package com.example.project;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TqsSimpleStack <T> {

    private ArrayList<T> stack;
    private int bound;

    public TqsSimpleStack(){
        this.stack = new ArrayList<>();
    }

    public TqsSimpleStack(int bound){
        this.stack = new ArrayList<>();
        this.bound = bound;
    }

    public void push(T x){
        if(this.bound > 0){
            if(this.stack.size() < bound){
                this.stack.add(x);
            }
            else {
                throw new IllegalStateException();
            }
        }else {
            this.stack.add(x);
        }
    }

    public T pop(){
        if(this.stack.size() == 0){
            throw new NoSuchElementException();
        }else {
            return this.stack.remove(this.stack.size() - 1);
        }
    }

    public T peek(){
        if(this.stack.size() == 0){
            throw new NoSuchElementException();
        }else {
            return this.stack.get(this.stack.size() - 1);
        }
    }

    public int size(){
        return this.stack.size();
    }

    public boolean isEmpty(){
        return this.stack.size() == 0;
    }

    public void emp(){
        this.stack.clear();
    }



}
