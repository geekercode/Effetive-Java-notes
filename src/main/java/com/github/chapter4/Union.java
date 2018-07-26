package com.github.chapter4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 优先考虑泛型化方法
 * 就如类可以从泛型中受益一般，方法也是一样。静态工具方法尤其适合于泛型化。
 * Collections中的所有的“算法”方法，例如（binarySearch和sort）都泛型化了。
 * Created by jhys on 2018/7/26
 */
public class Union {
    @SuppressWarnings("unused")
    public static <E> Set<E> union(Set<E> set1,Set<E> set2) {
        Set<E> result = new HashSet<E>(set1);
        result.addAll(set2);
        return result;
    }

    public static void main(String[] args) {
        Set<String> guys = new HashSet<String>(
                Arrays.asList("Tom", "Dick","Harry"));
        Set<String> stooges = new HashSet<String>(
                Arrays.asList("larry","Moe","Curly"));
        Set<String> alfCio = union(guys, stooges);
        System.out.println(alfCio);
    }
}
