package com.github.chapter9;

import java.util.concurrent.ConcurrentHashMap;

/**
 * HashMap与ConcurrentHashMap的区别
 * 那么对于Map来说，什么是线程安全呢？简单的来说，就是当多个线程同时在使用一个Map的时候，至少有一个线程对Map的结构进行了修改，
 * 那么必须保证这个修改被立即同步到其他线程中去，避免其他线程获取到错误的值。
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
