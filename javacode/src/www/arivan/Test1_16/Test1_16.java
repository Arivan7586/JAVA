package www.arivan.Test1_16;
import java.util.Scanner;

public class Test1_16 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入要求的数(0-54)：");
//        int n = scanner.nextInt();
//
//        Math1.returnMath(n);
//
//        System.out.println("-------------------------");
//        Math1.returnMath4();

        //Math1.specialMath();

//        System.out.println("请输入杨辉三角的行数(1-34)：");
//        int num = scanner.nextInt();
//        Math1.pascal(num);

//        System.out.println("下标为："+Math1.findMath());

        Math1.maxMinSum();
    }
}

class Math1 {
    public static void returnMath(int n){ //求回文数
        if (n > 1 && n < 54) {
            System.out.println("回文数为：");
            for(int a = 1; a < 10; a++){
                for(int b = 0; b < 10; b++){
                    for(int c = 0; c < 10; c++){
                        for(int d = 0; d < 10; d++){
                            for(int e = 0; e < 10; e++){
                                if(a == e && b == d){
                                    int sum = a+b+c+d+e;
                                    if(sum == n){
                                        System.out.println(a*10000+b*1000+c*100+d*10+e);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for(int a = 1; a < 10; a++){
                for(int b = 0; b < 10; b++){
                    for(int c = 0; c < 10; c++){
                        for(int d = 0; d < 10; d++){
                            for(int e = 0; e < 10; e++){
                                for(int f = 0; f < 10; f++){
                                    if(a == f && b == e && c == d){
                                        int sum = a+b+c+d+e+f;
                                        if(sum == n){
                                            System.out.println(a*100000+b*10000+c*1000+d*100+e*10+f);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("输入错误！");
        }
    }

    public static void returnMath4(){ //求出所有的四位数的回文数
        System.out.println("四位数的回文数有：");
        for(int a = 1; a < 10; a++){
            for(int b = 0; b < 10; b++){
                for(int c = 0; c < 10; c++){
                    for(int d = 0; d < 10; d++){
                        if(a == d && b == c){
                            System.out.println(a*1000 + b*100 + c*10 +d);
                        }
                    }
                }
            }
        }
    }

    public static void specialMath(){  //特殊的数，它等于它的每位数字的立方和
        System.out.println("特殊的数有(三位数)：");
        for(int a = 1; a <= 9; a++){
            for(int b = 0; b <= 9; b++){
                for(int c = 0; c <= 9; c++){
                    int num = a*100 + b*10 + c;
                    if(num == a*a*a + b*b*b + c*c*c){
                        System.out.println(num);
                    }
                }
            }
        }
//        System.out.println("-----------------------");
//        for(int i = 100; i <= 999; i++){
//            int a = i /100;
//            int b = (i / 10) % 10;
//            int c = i % 10;
//            if(i == a*a*a + b*b*b + c*c*c){
//                System.out.println(i);
//            }
//        }
    }

    public static void pascal(int n){ //杨辉三角
        if (n >= 1 && n <= 34) {
            int[][] arr = new int[n][n];
            for(int i = 0; i < n; i++){
                arr[i][0] = 1;
                arr[i][i] = 1;
                for(int j = 1; j < i; j++){
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }
            for(int i = 0; i < n; i++){
                for(int k = 1; k < (n-i); k++){
                    System.out.print(" ");
                }
                for(int j = 0; j < n; j++){
                    if (arr[i][j] != 0) {
                        System.out.print(arr[i][j]+" ");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("输入错误！");
        }
    }

    public static int findMath(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //输入数组的元素个数
        if (n >= 1 && n <= 100) {
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();  //给数组的每个元素赋值
            }
            int num = scanner.nextInt(); //输入要查找的数
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] == num){
                    return i+1;
                }
            }
        } else {
            return -1;
        }
        return -1;
    }

    public static void maxMinSum(){  //找出数组中最大值、最小值 、和
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        int n = scanner.nextInt();
        if(n >= 1 && n <= 10000){
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                int m = scanner.nextInt();
                if(m > -10000 && m < 10000){
                    arr[i] = m;
                }else {
                    System.out.println("第"+(i+1)+"个输入错误，输入范围应在1-10000！");
                }
            }
            System.out.println("输出为：");
            int max = arr[0];
            int min = arr[0];
            int sum = 0;
            for (int i = 1; i < arr.length; i++) {
                if(max < arr[i]){
                    max = arr[i];
                }
            }
            System.out.println(max);
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] < min){
                    min = arr[i];
                }
            }
            System.out.println(min);
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            System.out.println(sum);
        }else {
            System.out.println("输入错误，输入范围应在1-10000！");
        }
    }
}
