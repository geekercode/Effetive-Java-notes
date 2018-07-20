package github.chapter1;

/**
 * 缺少显式构造器的情况下，编译器会自动提供一个公有的、无参的缺省构造器（dafault constructor），
 * 所以常常可以看到一些被无意识地实例化的类。
 *
 * 这就需要强化此类不可实例化的能力，由于只有当类不包含显式的构造器时，
 * 编译器才会生成缺省的构造器，因此我们只需要将这个类包含私有构造器，它就不能被实例化了
 */

public class PrivateConstructor {
    private PrivateConstructor() {
        throw new AssertionError();
    }

    public static void main(String[] args) {
        new PrivateConstructor();
    }
}
