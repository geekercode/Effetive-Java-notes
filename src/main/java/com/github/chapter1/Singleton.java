package com.github.chapter1;

public class Singleton {
}

/**
 * 公有的成员是个静态工厂方法,这种方法很清晰的表明了这个类是一个Singleton
 */
class Elvis {
    private static final Elvis INSTANCE = new Elvis();
    private Elvis() {}
    public static Elvis getInstance() {
        return INSTANCE;
    }
    public void leaveTheBuilding() {
        System.out.println("Whos baby,I am outta here!");
    }

    public static void main(String[] args) {
        Elvis elvis = Elvis.getInstance();
        elvis.leaveTheBuilding();
    }
}