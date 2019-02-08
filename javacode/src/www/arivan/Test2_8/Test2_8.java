package www.arivan.Test2_8;
import java.util.Scanner;

public class Test2_8 {
    public static void main(String[] args) {
        A.run();
    }
}

class A {

//    计复数库，实现基本的复数加减乘除运算。
//            　　输入时只需分别键入实部和虚部，以空格分割，两个复数之间用运算符
//    分隔；输出时按a+bi的格式在屏幕上打印结果。参加样例输入和样例输出。
//            　　注意考虑特殊情况，无法计算时输出字符串"error"。

    public static void run(){
        Scanner reader = new Scanner(System.in);
        double a1 = reader.nextDouble();
        // System.out.println(Math.round(a1));//取double的整数部分
        double b1 = reader.nextDouble();
        String str = reader.next();
        double a2 = reader.nextDouble();
        double b2 = reader.nextDouble();

        double a = 0;
        double b = 0;
        boolean flag = true;

        if (str.equals("+")) {
            a = a1 + a2;
            b = b1 + b2;
        } else if (str.equals("-")) {
            a = a1 - a2;
            b = b1 - b2;
        } else if (str.equals("*")) {
            if ((a1 == a2) && (b1 == -b2)) {
                System.out.println(a1 * a1 + b1 * b1);
            } else {
                a = a1 * a2 - b1 * b2;
                b = a1 * b2 + b1 * a2;
            }
        } else if (str.equals("/")) {

            if (a2 == 0 && b2 == 0) {//无法计算时输出字符串"error"
                System.out.println("error");
                flag = false;
            } else {
                double c = a2 * a2 + b2 * b2;
                a = (a1 * a2 + b1 * b2) / c; //此题做除法要用double
                b = (b1 * a2 - a1 * b2) / c;
            }
        }
        if (flag) {

            if (b < 0) { //虚部为负
                if ((a - Math.round(a)) == 0) {//如果a=3.0
                    System.out.print(Math.round(a));//只输出整数部分，3
                } else {
                    System.out.print(a);//如果a=3.1，则输出3.1
                }
                if ((b - Math.round(b)) == 0) {
                    System.out.print(Math.round(b));
                } else {
                    System.out.print(b);
                }
            } else {  //虚部为正
                if ((a - Math.round(a)) == 0) {
                    System.out.print(Math.round(a));
                } else {
                    System.out.print(a);
                }
                System.out.print("+");
                if ((b - Math.round(b)) == 0) {
                    System.out.print(Math.round(b));
                } else {
                    System.out.print(b);
                }
            }
            System.out.println("i");
        }
    }
}