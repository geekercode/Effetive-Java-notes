package com.github.chapter5;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * EffectiveJava(36) -- 坚持使用Override注解
 * @author jhys
 * @date 2018/8/1
 */
public class Bigram {
    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    public boolean equals(Bigram b) {
        return b.first == first && b.second == second;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Bigram bigram = (Bigram) o;
//        return first == bigram.first &&
//                second == bigram.second;
//    }

    @Override
    public int hashCode() {
        return 31 * first + second;
    }

    public static void main(String[] args) {
        Set<Bigram> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            for(char c = 'a';c <= 'z';c++) {
                set.add(new Bigram(c,c));
            }
        }
        System.out.println("setSize = " + set.size());
    }
}
