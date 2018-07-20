package github.chapter2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 如果我们需要对对象进行排序的话，就必须定义对象的内在排序关系，即实现Comparable接口。
 * Created by jhys on 2018/7/18
 */
public class PersonInfo implements Comparable<PersonInfo>{
    private String name;
    private int age;

    public PersonInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(PersonInfo o) {
        if (this.age > o.age) {
            return 1;
        }
        else if (this.age < o.age) {
            return -1;
        }
        else return 0;

    }

    /**
     * 为了方便测试，我们重写了toString方法，然后调用Collections.sort()方法来对list进行排序。
     * @return
     */
    @Override
    public String toString() {
        return "PersonInfo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        List<PersonInfo> list = new ArrayList<>();
        list.add(new PersonInfo("John",18));
        list.add(new PersonInfo("Marry",21));
        list.add(new PersonInfo("Tom",20));
        System.out.println("Before sort: ");
        printList(list);
        Collections.sort(list);
        System.out.println("After sort: ");
        printList(list);

    }
    public static void printList(List<PersonInfo> list) {
        for(PersonInfo p : list) {
            System.out.println(p + " / ");
        }
        System.out.println();
    }

}
