package www.arivan.Test2_24;
import java.util.Scanner;

public class Test2_24 {
    public static void main(String[] args){
        A a = new A();
        Scanner in = new Scanner(System.in);
        double x = in.nextDouble();
        if(x < -1 || x > 1)
            return;
        a.test(x);
    }

}

class A {
//    3.题目：有10个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），
//    凡报到3的人退出圈子，问后留下 的是原来第几号的那位
    public final static double PI = Math.PI;
    public void test(double x){
        double i = 0, j = PI;
        double result = (i + j) / 2;
        double judge = Math.cos(result) - x;
        double temp;
        while(Math.abs(judge) > 0.000000000000001) {
            result = (i + j) / 2;
            temp = Math.cos(result);
            if(temp - x > 0) {
                i = result;
            } else {
                j = result;
            }
            judge = Math.cos(result) - x;

        }
        System.out.printf("%.5f", result);
        return;
    }
}