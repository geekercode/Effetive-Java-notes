package com.github.chapter6;

import java.util.Date;

/**
 * 第39条：必要时进行保护性拷贝
 * @author jhys
 * @date 2018/8/1
 */
public class Period {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if(this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(this.start +"after" + this.end);
        }
//        this.start = start;
//        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start,end);
        p.end.setYear(98);
        System.out.println(p.getStart() +"-====="+p.getEnd());
    }
}
