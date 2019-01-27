package www.arivan.Test1_27;
import java.util.Scanner;

public class Test1_27 {
    public static void main(String[] args){
        //System.out.println(Array.longest(Array.getArray()));

//        Scanner scanner = new Scanner(System.in);
//        int k = scanner.nextInt();
//        int n = scanner.nextInt();
//        int c = A.getFactor(k,n);
//        System.out.println(c);

//        Math1 math1 = new Math1();
//        System.out.println(math1.minCommonMultiple());

//        int[] arr = Factorization.getprime(20);
//        for(int i : arr){
//            System.out.println(i);
//        }

        Scanner scanner = new Scanner(System.in);
        Factorization.factorization(scanner.nextInt());

    }
}

class Factorization {

//    问题描述
//　　设计算法，用户输入合数，程序输出若个素数的乘积。例如，输入6，输出2*3。输入20，输出2*2*5。

    public static void factorization(int n){ //因式分解
        if(isPrime(n)){
            System.out.print(n);
        }else {
            int[] arr = getprime(n);
            for (int i = 0; i < arr.length; i++) {
                if(n%arr[i] == 0){
                    System.out.print(arr[i]+"*");
                    //factorization(n/arr[i]);
                    if(isPrime(n/arr[i])){
                        System.out.print(n/arr[i]);
                        break;
                    }else {
                        factorization(n/arr[i]);
                        break;
                    }
                }
            }
        }
    }

    public static int[] getprime(int n){ //找出1-n 的所有素数
        int[] arr = new int[n];
        int a = 0;
        for (int i = 2; i <= n; i++) {
            if(isPrime(i)){
                arr[a] = i;
                a++;
            }
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0){
                count++;
            }
        }
        int[] arr1 = new int[count];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[i];
        }
        return arr1;
    }

    public static boolean isPrime(int n){ //判断一个数是否为素数
        for (int i = 2; i < n; i++) {
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}

class A {

    //递归求二项式系数值
    public static int getFactor(int k, int n){
        if(k == 0 || k == n){
            return 1;
        }else {
            return getFactor(k,n-1)+getFactor(k-1,n-1);
        }
    }
}

class Math1 {
    public int minCommonMultiple(){  //求最小公倍数
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int i = 1;
        while (i*m % n != 0){ // *的优先级高于%
            i++;
        }
        return i*m;
    }
}

//class Array {
//    public static int[] getArray(){
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = scanner.nextInt();
//        }
//        return arr;
//    }
//
//    public static int longest(int[] arr){
//        int[] m = new int[arr.length];
////        for (int i = 0; i < m.length; i++) {
////            m[i] = 0;
////        }
//        int max = 0;
//        for (int i = 0; i < arr.length; i++) {
//            int a = arr[i];
//            for (int j = i+1; j < arr.length; j++) {
//                if(arr[j] > a){
//                    m[i]++;
//                    a = arr[j];
//                }
//            }
//            if(m[i] > max){
//                max = m[i];
//            }
//        }
//        return max;
//    }
//}