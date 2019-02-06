package www.arivan.Test2_6;
import java.util.Scanner;

public class Test2_6 {
    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        f.fib(20);

//        A test = new A();
//        Scanner in = new Scanner(System.in);
//        String A = in.next();
//        test.printResult(A);
    }
}

class Fibonacci{
    public void fib(int n){  //求前n个斐波那契数
        int a = 1;
        int b = 1;
        int c = 1;
        if(n <= 1 && n != 0){
            System.out.print(a+"、");
        }else if(n <= 2 && n > 1){
            System.out.print(a+"、");
            System.out.print(b+"、");
        }else{
            System.out.print(a+"、");
            System.out.print(b+"、");
            while(n > 2){
                a = b;
                b = c;
                c = a + b;
                n = n - 1;
                System.out.print(c+"、");
            }
        }
    }
}

class A {
    public int[] getNext(char[] arrayB) {  //周期字串
        int[] next = new int[arrayB.length + 1];
        int j = 0;
        for(int i = 0;i < arrayB.length;i++) {
            while(j > 0 && arrayB[i] != arrayB[j])
                j = next[j];
            if(arrayB[j] == arrayB[i])
                j++;
            next[i + 1] = j;
        }
        return next;
    }

    public int getKMP(char[] arrayA, char[] arrayB) {
        int max = 0;
        int[] next = getNext(arrayB);
        int j = 0;
        int tempi = -1;
        for(int i = 0;i < arrayA.length;i++) {
            while(j > 0 && arrayA[i] != arrayB[j])
                j = next[j];
            if(arrayA[i] == arrayB[j])
                j++;
            if(j == arrayB.length) {
                if(i - tempi != arrayB.length)
                    break;
                tempi = i;
                max++;
                j = 0;
            }
        }
        return max;
    }

    public void printResult(String A) {
        char[] arrayA = A.toCharArray();
        int max = arrayA.length;
        for(int i = 0; i < arrayA.length; i++) {
            int len = i + 1;
            if(len > arrayA.length / 2)
                break;
            else if(arrayA.length % len != 0)
                continue;
            char[] arrayB = new char[len];
            for(int j = 0;j < arrayB.length;j++)
                arrayB[j] = arrayA[j];
            int tempMax = arrayA.length / arrayB.length;
            if(tempMax == getKMP(arrayA, arrayB)) {
                max = arrayB.length;
                break;
            }
        }
        System.out.println(max);
        return;
    }
}