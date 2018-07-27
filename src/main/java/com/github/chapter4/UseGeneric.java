package com.github.chapter4;

/**
 * https://www.cnblogs.com/shijiaqi1066/p/3441445.html
 * Java语言引入泛型的好处是安全简单。泛型的好处是在编译的时候检查类型安全，
 * 并且所有的强制转换都是自动和隐式的，提高代码的重用率。
 * Created by jhys on 2018/7/26
 */

public class UseGeneric<T> {
    private T ob; // 定义泛型成员变量

    public UseGeneric(T ob) {
        this.ob = ob;
    }
    public T getOb() {
        return ob;
    }
    public void setOb(T ob) {
        this.ob = ob;
    }
    public void showType() {
        System.out.println("T的实际类型是: " + ob.getClass().getName());
    }
}
class UseGenericDemo {
    public static void main(String[] args) {
        // 定义泛型类UseGeneric的一个Integer版本
        UseGeneric<Integer> intOb = new UseGeneric<Integer>(88);
        intOb.showType();
        int i = intOb.getOb();
        System.out.println("value= " + i);
        System.out.println("----------------------------------");
        // 定义泛型类UseGeneric的一个String版本
        UseGeneric<String> strOb = new UseGeneric<String>("Hello UseGeneric!");
        strOb.showType();
        String s = strOb.getOb();
        System.out.println("value= " + s);

    }
}