package com.github.chapter7;

/**
 * 051：当心字符串连接的性能
 * @author jhys
 * @date 2018/8/2
 */
public class TestString {
    public static void main(String[] args) {
        useString();
        useStringBuilder();
    }

    private static void useString() {
        String str = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            str += i;
        }
       // System.out.println(str);
        System.out.println(System.currentTimeMillis() - start);
    }
    //StringBuilder 字符串变量（非线程安全）
    private static void useStringBuilder() {
        StringBuilder str = new StringBuilder();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            str.append(i);
        }
     //   System.out.println(str);
        System.out.println(System.currentTimeMillis() - start);
    }

}
