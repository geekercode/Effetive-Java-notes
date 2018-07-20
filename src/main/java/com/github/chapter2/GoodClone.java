package com.github.chapter2;

/**
 * 实现对象的拷贝的好办法是提供一个拷贝构造器(copy constructor)或者拷贝工厂(copy factory)
 * 拷贝构造器(copy constructor)或者拷贝工厂(copy factory)展示
 * Created by jhys on 2018/7/18
 */
public class GoodClone {
    private int type;
    private final String special;

    public GoodClone(int type, String special) {
        this.type = type;
        this.special = special;
    }

    /**
     * 拷贝构造器
     * @param goodClone
     */
    public GoodClone(GoodClone goodClone) {
        this.special = goodClone.special;
        this.type = goodClone.type;
    }

    /**
     * 拷贝工厂
     * @param goodClone
     * @return
     */
    public static GoodClone newInstance(GoodClone goodClone) {
        return new GoodClone(goodClone.type,goodClone.special);
    }

    public static GoodClone cloneInstance(GoodClone goodClone) {
        return new GoodClone(goodClone.type,goodClone.special);
    }

    public static void main(String[] args) {
        GoodClone entity = new GoodClone(10,"specialGood");
        GoodClone copyEd1 = GoodClone.newInstance(entity);
        System.out.println("----------克隆方式newInstance-----------"
                + (entity == copyEd1));

        GoodClone copyEd2 = new GoodClone(entity);
        System.out.println("----------克隆方式2-----------" + (entity == copyEd2));

        System.out.println("----------克隆方式1与克隆方式2-----------"
                + (copyEd1 == copyEd2));
    }
}
