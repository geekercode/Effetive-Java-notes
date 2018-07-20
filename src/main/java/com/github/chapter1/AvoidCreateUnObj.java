package com.github.chapter1;

/**
 * 这个程序的结果是正确的，但由于写错了一个字符，运行的结果要比实际慢很多。
 * 变量sum被声明成了Long而不是long，这意味着程序构造了大约231不必要的Long实例
 * （大约每次往Long类型的 sum变量中增加一个long类型构造的实例），把sum变量的类型由Long改为long，
 * 在我的机器上运行时间从8.92秒降低到1.147秒。
 */
public class AvoidCreateUnObj {
    public static void main(String[] args) {
        double startTime = System.currentTimeMillis();
       // Long sum = 0L;    //Long,long的区别
        long sum = 0L;
        for (int i = 0; i <Integer.MAX_VALUE ; i++) {
            sum += i;
        }
        double endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime)/1000+"s");
        System.out.println(sum);
    }
}
