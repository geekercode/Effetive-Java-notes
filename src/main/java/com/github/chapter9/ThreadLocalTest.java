package com.github.chapter9;

import java.util.HashMap;
import java.util.Map;

/**
 * get()方法是用来获取ThreadLocal在当前线程中保存的变量副本，set()用来设置当前线程中变量的副本，
 * remove()用来移除当前线程中变量的副本，initialValue()是一个protected方法，
 * 一般是用来在使用时进行重写的，它是一个延迟加载方法
 * @author jhys
 * @date 2018/8/19
 */
class GetLocal {
    static ThreadLocal<HashMap> threadLocal = new ThreadLocal<HashMap>() {
            @Override
            protected HashMap initialValue() {
                return new HashMap();
            }
        };
}

class MyThread implements Runnable {
    // private Map map = new HashMap();
    @Override
    public void run() {
        Map map = GetLocal.threadLocal.get();

        for (int i = 0; i < 10; i++) {
            map.put(i, i); // 向map中添加值

            try {
                Thread.sleep(200);
            } catch (Exception ex) {
            }
        }

        System.out.println(Thread.currentThread().getName() + "# map.size()=" +
            map.size() + " # " + map);
    }
}

public class ThreadLocalTest {
    public static void main(String[] args) {
        MyThread mt = new MyThread();

        Thread[] runs = new Thread[5]; // 创建5个线程

        for (int i = 0; i < runs.length; i++) {
            runs[i] = new Thread(mt);
            runs[i].start(); // 启动线程
        }
    }
}