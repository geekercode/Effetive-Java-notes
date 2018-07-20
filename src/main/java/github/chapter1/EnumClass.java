package github.chapter1;

/**
 * enum 的全称为 enumeration， 是 JDK 1.5 中引入的新特性。
 * 枚举的典型应用场景：错误码、状态机等。
 */
public enum EnumClass {
    OK(0, "成功"),
    ERROR_A(100, "错误A"),
    ERROR_B(200, "错误B");

    EnumClass(int code, String description) {
        this.code = code;
        this.description = description;
    }

    private int code;
    private String description;

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for(EnumClass enumClass:EnumClass.values()) {
            System.out.println("code: " + enumClass.getCode() +", description: " +enumClass.getDescription());
        }
    }
}
