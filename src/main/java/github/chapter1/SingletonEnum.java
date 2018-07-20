package github.chapter1;

/**
 * 利用单元素的枚举来实现单例（Singleton），绝对防止多次实例化
 */
public enum SingletonEnum {
    INSTANCE;
    private String field01;

    public  String getField01() {
        return field01;
    }

    public void setField01(String field01) {
        this.field01 = field01;
    }

    public static void main(String[] args) {
        SingletonEnum.INSTANCE.setField01("123");
        System.out.println(SingletonEnum.INSTANCE.getField01());
    }
}
