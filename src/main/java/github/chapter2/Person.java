package github.chapter2;

/**
 * https://blog.csdn.net/zhangjg_blog/article/details/18369201
 * Created by jhys on 2018/7/18
 */

public class Person implements Cloneable{
    private String name;
    private int age;
    private boolean sex;

    public Person(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    /**
     * 我们可以看到结果：对于复制引用，即对象p1，它所指向的地址和源对象地址是相同的，
     而对于对象p2,它是通过clone方法获取到一个新的对象地址，和源地址是不同的。
     可见，复制引用只是将引用指向了源对象地址，而clone方法是真正地克隆了一个对象。
     * @param args
     * @throws CloneNotSupportedException
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p = new Person("John",21,true);
        Person p1 = p;
        Person p2 = (Person) p.clone();
        System.out.println("p: " + p);
        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
    }
}
