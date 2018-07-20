package github.chapter2;

import java.util.HashSet;
import java.util.Set;

public class HashTest {
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
    public int hashCode() {
        return i % 10;
    }

    /**
     * 两个对象的hashCode相同，并不一定表示两个对象就相同
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        //对象为空
       if(obj == null) {
           return false;
       }
        //对象等于本身
       if(obj == this) {
           return true;
       }
        //对象不属于HashTest类，直接返回false
       if(!(obj instanceof HashTest)) {
           return false;
       }
       HashTest other = (HashTest) obj;
       if(other.getI() == this.getI()) {
           return true;
       }
       return false;
    }

    public static void main(String[] args) {
        HashTest a = new HashTest();
        HashTest b = new HashTest();
        a.setI(1);
        b.setI(1);
        Set<HashTest> set = new HashSet<>();
        set.add(a);
        set.add(b);
        System.out.println(a.hashCode() == b.hashCode());
        System.out.println(a.equals(b));
        System.out.println(set);
        
    }
}