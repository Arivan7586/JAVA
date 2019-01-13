package www.arivan.Test1_13;
import java.util.Scanner;

public class Test1_13 {
    public static void main(String[] args){
//        System.out.println("请输入要求的覅波纳契数：");
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        Fibonacci f = new Fibonacci();
//        System.out.println(f.fib(n));
//
       // Circle circle = new Circle();
        Circle.area();
    }
}

//Fibonacci数列的递推公式为：Fn=Fn-1+Fn-2，其中F1=F2=1。
//        当n比较大时，Fn也非常大，现在我们想知道，Fn除以10007的余数是多少。

class Fibonacci {
    public long fib(int n){
        if (n >= 1 && n <= 1000000) {
            int a = 1;
            int b = 1;
            int c = 1;
            while(n > 2){
                a = b;
                b = c;
                c = a + b;
                n--;
            }
            long m = (long)c;
            if(m >= 10007){
                return m%10007;
            }else {
                return m;
            }
        }else {
            return 0;
        }
    }
}

class Circle {
    public static void area(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入圆的半径：");
        while (true) {
            double n = scanner.nextDouble();
            if(n >= 1 && n <= 10000){
                System.out.println("圆的面积为："+(3.14*n*n));
                break;
            }else {
                System.out.println("输入范围有误，请重新输入：");
            }
        }

    }
}