package com.github.chapter3;

/**
 * Created by jhys on 2018/7/24
 */
public class Out {
    private static int a = 5;
    private int b;
    public static class Inner {
        public void print() {
            System.out.println(a);
        }
    }
}
class TestOut {
    public static void main(String[] args) {
        Out.Inner inner = new Out.Inner();
        inner.print();
    }
}
