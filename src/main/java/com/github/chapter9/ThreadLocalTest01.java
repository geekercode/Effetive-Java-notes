package com.github.chapter9;

/**
 * 启动5个线程，线程向map中写入10个整数值，然后输出map。运行该程序，
 * 观察结果我们会发现map中不止10个元素，这说明程序产生了线程安全问题
 * @author jhys
 * @date 2018/8/19
 */
import java.util.HashMap;
import java.util.Map;

class MyThread01 implements Runnable {
    private Map map = new HashMap(); // 定义HashMap

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            map.put(i, i); // 向map中添加值

            try {
                Thread.sleep(100);
            } catch (Exception ex) {
            }
        }

        System.out.println(Thread.currentThread().getName() + "# map.size()=" +
                map.size() + " # " + map);
    }
}

public class ThreadLocalTest01 {
    public static void main(String[] args) {
        MyThread01 mt = new MyThread01();

        Thread[] runs = new Thread[5]; // 创建5个线程

        for (int i = 0; i < runs.length; i++) {
            runs[i] = new Thread(mt);
            runs[i].start(); // 启动线程
        }
    }
}