package com.github.chapter3;

/**
 * java中的接口回调机制
 * 同步调用是一种阻塞式调用，即在函数A的函数体里通过书写函数B的函数名来调用之，使内存中对应函数B的代码得以执行。
   异步调用是一种类似消息或事件的机制解决了同步阻塞的问题，例如 A通知 B后，他们各走各的路，互不影响，不用像同步调用那样， A通知 B后，非得等到 B走完后， A才继续走 。
   回调是一种双向的调用模式，也就是说，被调用的接口被调用时也会调用对方的接口，例如A要调用B，B在执行完又要调用A。
 * Created by jhys on 2018/7/24
 */

/**
 * 首先定义一个接口
 */
public interface CallBack {
    public void doEvent();
}
/**
 * 然后定义调用方，也就是所谓的控制类，主导什么时候进行回调
 */
class Master {
    CallBack callback;

    public Master(CallBack callback) {
        this.callback = callback;
    }
    public void process() {
        System.out.println("主程序执行中!");
        callback.doEvent();
    }
}

/**
 * 接着定义被回调的类，用于响应回调发生的处理事件：
 */
class Slave implements CallBack {
    @Override
    public void doEvent() {
        System.out.println("告知工作已经完成了");
    }

    /**
     * 这个被调用的类继承了协商好的接口，然后在其中实现被调用的方法，也就是接口中的doEvent方法。 最后就是完成整个回调的调用流程：
     * @param args
     */
    public static void main(String[] args) {
        //创建回调对象实例
        Slave slave = new Slave();
        //创建控制器对象，将提供给他的回调对象传入
        Master master = new Master(slave);
        //启动控制器对象运行
        master.process();
    }
}