package com.github.chapter1;

/**
 * 静态工厂方法替代构造器
 */
public class StaticFactory {
}

class Father {
    private Father() {
    }

    public static Father newInstance(String type) {
        if (type.equals("ChildA")) {
            return new ChildA();
        } else {
            return new ChildB();
        }
    }
    public  void getName() {
        System.out.println("My name is father");
    }

    private static class ChildA extends Father {
        public void getName() {
            System.out.println("My name is child A");
        }
    }
    private static class ChildB extends Father {
        public void getName() {
            System.out.println("My name is child B");
        }
    }

}

class Test {
    public static void main(String[] args) {
        Father father1 = Father.newInstance("ChildA");
        father1.getName();
        Father father2 = Father.newInstance("ChildB");
        father2.getName();
    }
}
