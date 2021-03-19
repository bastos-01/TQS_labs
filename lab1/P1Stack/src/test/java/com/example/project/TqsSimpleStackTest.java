package com.example.project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TqsSimpleStackTest {

    private TqsSimpleStack<String> stack;
    private TqsSimpleStack<String> emp_stack;
    private TqsSimpleStack<String> bounded_stack;

    @BeforeEach
    void startup(){
        emp_stack = new TqsSimpleStack<>();
        stack = new TqsSimpleStack<>();
        stack.push("aveiro");
        stack.push("coimbra");
        stack.push("leiria");
        bounded_stack = new TqsSimpleStack<>(2);
        bounded_stack.push("value1");
        bounded_stack.push("value2");
    }

    @AfterEach
    void emp(){
        stack.emp();
        bounded_stack.emp();
    }

    @Test
    void isEmpty(){
        assertTrue(emp_stack.isEmpty(), "Empty stack should return empty");
    }

    @Test
    void pop(){
        assertEquals("leiria", stack.pop());
        assertEquals(2, stack.size());
    }

    @Test
    void peek(){
        assertEquals("leiria", stack.peek());
        assertEquals(3, stack.size());
    }

    @Test
    void size(){
        assertEquals(3, stack.size());
        stack.pop();
        assertEquals(2, stack.size());
    }

    @Test
    void push(){
        stack.push("cidade");
        assertEquals("cidade", stack.peek());
        assertEquals(4, stack.size());
    }

    // a)
    @Test
    void emptyOnConstruction(){
        assertTrue(emp_stack.isEmpty());
    }

    // b)
    @Test
    void sizeZeroOnConstruction(){
        assertEquals(0, emp_stack.size());
    }

    // c)
    @Test
    void nPushes(){
        emp_stack.push("um");
        emp_stack.push("dois");
        emp_stack.push("tres");
        assertFalse(emp_stack.isEmpty());
        assertEquals(3, emp_stack.size());
    }

    // d)
    @Test
    void pushPop(){
        emp_stack.push("value");
        assertEquals("value", emp_stack.pop());
    }

    // e)
    @Test
    void pushPeek(){
        emp_stack.push("value");
        assertEquals("value", emp_stack.peek());
        assertEquals(1, emp_stack.size());
    }

    // f)
    @Test
    void nPops(){
        stack.pop();
        stack.pop();
        stack.pop();
        assertTrue(emp_stack.isEmpty());
        assertEquals(0, emp_stack.size());
    }

    // g)
    @Test
    void popFromEmpty(){
        assertThrows(NoSuchElementException.class, () -> {
            emp_stack.pop();
        });
    }

    // h)
    @Test
    void peekFromEmpty(){
        assertThrows(NoSuchElementException.class, () -> {
            emp_stack.peek();
        });
    }

    // h)
    @Test
    void boundedStack(){
        assertThrows(IllegalStateException.class, () -> {
            bounded_stack.push("value3");
        });
    }



}