package com.github.chapter7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 第46条：for-each循环优先于传统的for循环
 * @author jhys
 * @date 2018/8/2
 */
public class ForEach {

    // 不简洁，同时易误导致bug
/*   for (Iterator<String> i = list.iterator();i.hasNext();) {
        for (Iterator<String> j = list2.iterator();j.hasNext();) {
            doSomething(i.next(),j.next());
        }
    }

    // 简洁
    for (String s : list) {
        for (String s1 : list2) {
            doSomething(s,s1);
        }

    }
*/
}
