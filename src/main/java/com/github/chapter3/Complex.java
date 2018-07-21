package com.github.chapter3;

/**第15条：使可变性最小化
 * https://my.oschina.net/jtzen9/blog/1524400
 * Created by jhys on 2018/7/20
 */
public class Complex {
    private final double re; //实部
    private final double im; //虚部

    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static Complex valueOf(double re, double im) {
        return new Complex(re,im);
    }
    public double realPart() {
        return re;
    }
    public double imaginaryPart() {
        return im;
    }

    //复数相加
    public Complex add(Complex c) {
        return new Complex(re + c.re,im + c.im);
    }

}
//创建一个配套类
class ComplexBuilder {
    private double re;
    private double im;

    private ComplexBuilder(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static ComplexBuilder newInstance(Complex c) {
        return new ComplexBuilder(c.realPart(), c.imaginaryPart());
    }

    public void add(Complex c) {
        this.re = this.re + c.realPart();
        this.im = this.im + c.imaginaryPart();
    }
    public Complex toComplex() {
        return Complex.valueOf(this.re, this.im);
    }
}
/**
 *在客户端中我们如果需要用一个复数和另一个复数相加100次，我们如果不用ComplexBuilder的话就像下面这样，
 * 算上最开始穿件的两个实例，我们将会创建102个实例：
 */
class Test1 {
    public static void main(String[] args) {
        Complex c1 = Complex.valueOf(1, 2);
        Complex c2 = Complex.valueOf(2, 3);
        for (int i = 0; i < 100; i++) {
            c1 = c1.add(c2);
        }
    }
}

/**
 * 现在改用ComplexBuilder，现在我们只会创建4个实例
 */
class Test {
    public static void main(String[] args) {
        Complex c1 = Complex.valueOf(1,2);
        Complex c2 = Complex.valueOf(2, 3);
        ComplexBuilder cb = ComplexBuilder.newInstance(c1);
        for (int i = 0; i < 100; i++) {
            cb.add(c2);
        }
        c1 = cb.toComplex();
    }
}