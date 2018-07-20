package com.github.chapter1;
import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Java有垃圾回收机制，那么还存在内存泄露吗？答案是肯定的，所谓的垃圾回收GC会自动管理内存的回收，而不需要程序员每次都手动释放内存，
 * 但是如果存在大量的临时对象在不需要使用时并没有取消对它们的引用，就会吞噬掉大量的内存，很快就会造成内存溢出。
 *
 *
 */
public class EliminateObsoleteObjectReferences {

}

/**
 * 先进行入栈，然后，再出栈。入栈５个元素，然后，再出栈５个元素。那么此时，会有５个元素不会被销毁，因为，elements中，
 * 持有指向５个对象的引用（保存了５个已经出栈的引用，只有再一次入栈５个引用）。出现内存泄露。
 */
class Stack {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {

        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {

        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }

    /**
     * Ensure space for at least one more element, roughly doubling the capacity
     * each time the array needs to grow
     */
    private void ensureCapacity() {

        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

}
