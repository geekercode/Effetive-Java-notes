package com.github.chapter9;

import java.util.concurrent.ConcurrentHashMap;

/**
 * HashMap与ConcurrentHashMap的区别
 * 1.那么对于Map来说，什么是线程安全呢？简单的来说，就是当多个线程同时在使用一个Map的时候，至少有一个线程对Map的结构进行了修改，
 * 那么必须保证这个修改被立即同步到其他线程中去，避免其他线程获取到错误的值。
 * 2.在ConcurrentHashMap中，无论是读操作还是写操作都能保证很高的性能：在进行读操作时(几乎)不需要加锁，
 * 而在写操作时通过锁分段技术只对所操作的段加锁而不影响客户端对其它段的访问。特别地，在理想状态下，
 * ConcurrentHashMap 可以支持 16 个线程执行并发写操作（如果并发级别设为16），及任意数量线程的读操作。
 * @author jhys
 * @date 2018/8/3
 */
public class ConcurrentHashMapTest {

    private static ConcurrentHashMap<Integer,Integer> concurrentHashMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        new Thread("Thread1") {
            @Override
            public void run() {
                concurrentHashMap.put(3,33);
            }
        };
        new Thread("Thread2") {
            @Override
            public void run() {
                concurrentHashMap.put(4,44);
            }
        };
        new Thread("Thread3") {
            @Override
            public void run() {
                concurrentHashMap.put(7,77);
            }
        };
        System.out.println(concurrentHashMap);
    }
}
