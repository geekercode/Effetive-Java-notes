package github.chapter2;

import java.util.HashMap;
import java.util.Map;

/**
 * 在Effective Java中的第九条说：覆盖equals总要覆盖hashCode。
 “一个很常见的错误根源在于没有覆盖hashCode方法，在每个覆盖了equals方法的类中，也必须覆盖hashCode方法。”
 以下约定内容摘自Object规范[JavaSE6]:
 1. 在 Java 应用程序执行期间，在对同一对象多次调用 hashCode 方法时，必须一致地返回相同的整数，
 前提是将对象进行 equals 比较时所用的信息没有被修改。从某一应用程序的一次执行到同一应用程序的另一次执行，该整数无需保持一致。
 2. 如果根据 equals(Object) 方法，两个对象是相等的，那么对这两个对象中的每个对象调用 hashCode 方法都必须生成相同的整数结果。
 3. 如果根据 equals(java.lang.Object) 方法，两个对象不相等，那么对这两个对象中的任一对象上调用 hashCode 方法不
 要求一定生成不同的整数结果。但是，程序员应该意识到，为不相等的对象生成不同整数结果可以提高哈希表的性能。
 */
public final class Box {
    private int length;
    private int width;
    private int heigth;

    public Box() {

    }

    public Box(int length, int width, int heigth) {
        this.length = length;
        this.width = width;
        this.heigth = heigth;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    @Override
    //重写equals方法。
    /**
     * 实现高质量equals方法的诀窍:
     1.使用==操作符检查“参数是否为这个对象的引用”。
     2.使用instanceof操作符检查“参数是否为正确的类型”。
     3.把参数转化为正确的类型。
     4.对于该类的中每个关键域，检查参数中的域是否与该对象中对应的域想匹配。
     */
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Box)) {
            return false;
        } else {
            Box boxtmp = (Box) o;
            return boxtmp.heigth == this.heigth
                    && boxtmp.width == this.width
                    && boxtmp.length == this.length;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = result * 31 + length;
        result = result * 31 + heigth;
        result = result * 31 + width;
        return result;
    }

}

class HashCodeAndEqualTest {
    public static void main(String[] args) {
        Map<Box, Integer> map = new HashMap<>();
        Box a = new Box(1, 2, 3);
        Box b = new Box(1, 2, 3);
        System.out.println("a == b :" + (a == b));
        System.out.println("a .equals(b):" + a.equals(b));
        map.put(a, 1);
        System.out.println(map.get(a));
        System.out.println(map.get(b));
    }
}