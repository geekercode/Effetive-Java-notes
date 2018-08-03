package com.github.chapter9;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch是在java1.5被引入的，存在于java.util.concurrent包下。
 * CountDownLatch这个类能够使一个线程等待一定数量（计数器）线程完成各自的工作后再执行后续代码。
 * @author jhys
 * @date 2018/8/3
 */
public class Worker implements Runnable {
    /**
     * 线程计数器
     */
    private CountDownLatch countDownLatch;
    /**
     * 线程睡眠时长
     */
    private long timeout;

    public Worker(CountDownLatch countDownLatch, long timeout) {
        this.countDownLatch = countDownLatch;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        try {//模拟业务操作，睡眠1秒
            TimeUnit.SECONDS.sleep(timeout);
            System.out.println("线程：" + Thread.currentThread().getName() + "执行完毕!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }
}
class CountDownLatchMain {
    //执行线程数
    private static int threadNumbers = 10;

    public static void main(String[] args) throws InterruptedException {
        //创建计数器
        CountDownLatch countDownLatch = new CountDownLatch(threadNumbers);
        for (int i = 0; i < threadNumbers ; i++) {
            new Thread(new Worker(countDownLatch,i)).start();
        }
        StringBuilder sb = new StringBuilder();
        while (countDownLatch.getCount() > 0){
            sb.append("=");
            double percent = (double) ((threadNumbers - countDownLatch.getCount()) * 100) / threadNumbers;
            System.out.println(sb.toString() + percent + "%");
            TimeUnit.MILLISECONDS.sleep(1000);
        }

        double percent = (double) ((threadNumbers - countDownLatch.getCount()) * 100) / threadNumbers;
        System.out.println(sb.toString() + percent + "%");

        countDownLatch.await();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("所有线程执行完毕，主线程继续执行！");
    }
}
