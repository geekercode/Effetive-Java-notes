package com.github.chapter3;

/**
 * 组合和继承，都能实现对类的扩展。
 * Created by jhys on 2018/7/21
 */
public class SuperCallClass {
    public void call() {

    }

    public void operator1() {
        System.out.println("operator1 in super class");
    }

    public void operator2() {
        System.out.println("operator2 in super class");
    }

    /**
     * 冗余的函数，导致子类臃肿，破坏了封装，增加了出错机会
     */
    public void redudant() {
        System.out.println("redundant in super class");
    }
}

/**
 * 组合类的使用
 * 综上概述：
  组合通常优于继承，
 1.考虑使用多态，可以用继承。
 2.考虑复用父类方法，而且父类很少改动，可以用继承。
 其他情况请慎重使用继承。
 */
class CombineCallClass {
    private SuperCallClass superCallClass;

    public CombineCallClass() {
        superCallClass = new SuperCallClass();
    }

    public void operator1() {
        System.out.println("operate in combine class");
    }
    /**
     * 只需要使用到SuperCallClass中的operate2方法
     */
    public void operator2() {
        superCallClass.operator2();
    }
    public void call() {
        operator1();
    }
}
