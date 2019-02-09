package www.arivan.Test2_9;
import java.util.Scanner;

public class Test2_9 {
    public static void main(String[] args) {
        A test = new A();
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double b = in.nextDouble();
        test.run(a, b);
    }
}

class A {
    public void run(double a, double b) {
        double c = Math.sqrt(a*a + b*b);
        if(a % c != 0) {
            a = a / c;
            System.out.printf("%.1f", a);
        } else {
            a = a / c;
            int a1 = (int) a;
            System.out.println(a1);
        }
        if(b > 0)
            System.out.print("+");
        if(b % c != 0) {
            b = b / c;
            System.out.printf("%.1f", b);
        } else {
            b = b / c;
            int b1 = (int) b;
            System.out.print(b1);
        }
        System.out.println("i");
    }
}