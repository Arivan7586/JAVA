package www.arivan.Test1_19;
import java.util.Scanner;

public class Test1_19 {
    public static void main(String[] args){
//        int[][] arr = Array.enteringTwoArray(4);
//        Array.printArray(arr);

        int[][] arr1 = new int[][]{{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        //System.out.println(Array.heng(arr1,2,2));
        //System.out.println(Array.xiaDuiJiaoXian(arr1,3,1));
        //System.out.println(Array.shangDuiJiaoXian(arr1,1,4));
       // Array.empress(4);

        Array.readTime();
    }
}

class Array {

    //    给定一个n*n的棋盘，棋盘中有一些位置不能放皇后。现在要向棋盘中放入n个黑皇后和n个白皇后，
//    使任意的两个黑皇后都不在同一行、同一列或同一条对角线上，任意的两个白皇后都不在同一行、
//    同一列或同一条对角线上。问总共有多少种放法？n小于等于8。
    public static void empress(int n){ //皇后问题
//        int whiteEmpress = n;
//        int blackEmpress = n;
//        int[][] arr = enteringTwoArray(n);
//        int sum = 0;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                if(arr[i][j] == 1){
//                    sum++;
//                }
//            }
//        }
//        int num = 0; //记录放法
//        while (sum > 0) {
//            for (int i = 0; i < arr.length; i++) {
//                for (int j = 0; j < arr[i].length; j++) {
//                    if(arr[i][j] == 1 && heng(arr,i,j) && shu(arr,i,j) && whiteEmpress > 0
//                            && xiaDuiJiaoXian(arr,i,j) && shangDuiJiaoXian(arr,i,j)){
//                        arr[i][j] = 2; //2代表白皇后
//                        whiteEmpress--;
//                        sum--;
//                    }
//                    if(arr[i][j] == 1 && heng(arr,i,j) && shu(arr,i,j) && blackEmpress > 0
//                            && xiaDuiJiaoXian(arr,i,j) && shangDuiJiaoXian(arr,i,j)){
//                        arr[i][j] = 3;  //3代表黑皇后
//                        blackEmpress--;
//                        sum--;
//                    }
//                }
//            }
//            if(whiteEmpress == 0 && blackEmpress == 0){
//                num++;
//            }
//        }
//        System.out.println(num);
    }

    public static int[][] enteringTwoArray(int n){ //初始化数组
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        return arr;
    }

    public static void printArray(int[][] arr){ //输出二维数组
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void printArray(int[] arr){ //输出一维数组
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static boolean heng(int[][] arr, int m, int n){ //判断二维数组第n行中某元素是否在本行有相同的元素
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[m][i] == arr[m][n]){
                count++;
            }
        }
        if(count > 1){
            return false;
        }else {
            return true;
        }
    }

    public static boolean shu(int[][] arr, int m, int n){ //判断二维数组第n行中某元素是否在本列有相同的元素
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i][n] == arr[m][n]){
                count++;
            }
        }
        if(count > 1){
            return false;
        }else {
            return true;
        }
    }

    public static boolean xiaDuiJiaoXian(int[][] arr, int m, int n){ //判断二维数组元素同一斜向下对角线是否有相同元素
        int i = 1;
        int count = 0;
        while(m-i >= 0 && n-i >=0){
            if(arr[m][n] == arr[m-i][n-i]){
                count++;
            }
            i++;
        }
        while(m+i < arr.length && n+i < arr[m].length){
            if(arr[m][n] == arr[m+i][n+i]) {
                count++;
            }
            i++;
        }
        if(count > 0){
            return false;
        }else {
            return true;
        }
    }

    public static boolean shangDuiJiaoXian(int[][] arr, int m, int n){ //判断二维数组元素同一斜向上对角线是否有相同元素
        int i = 1;
        int count = 0;
        while(m+i < arr.length && n-i >= 0){
            if(arr[m][n] == arr[m+i][n-i]){
                count++;
            }
            i++;
        }
        while (m-i >=0 && n+i < arr.length){
            if(arr[m][n] == arr[m-i][n+i]){
                count++;
            }
            i++;
        }
        if(count > 0){
            return false;
        }else {
            return true;
        }
    }

    //给定当前的时间，请用英文的读法将它读出来。
//    时间用时h和分m表示，在英文的读法中，读一个时间的方法是：
//            　　如果m为0，则将时读出来，然后加上“o'clock”，如3:00读作“three o'clock”。
//            　　如果m不为0，则将时读出来，然后将分读出来，如5:30读作“five thirty”。

    public static void readTime(){ //报时方法
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入时间：");
        int h = scanner.nextInt();
        int m = scanner.nextInt();
        if(h >= 0 && h < 24 && m >= 0 && m < 60){
            String hour = null;
            String minute = null;
            String[] time = new String[51];
            time[0] = "zero";
            time[1] = "one";
            time[2] = "two";
            time[3] = "three";
            time[4] = "four";
            time[5] = "five";
            time[6] = "six";
            time[7] = "seven";
            time[8] = "eight";
            time[9] = "nine";
            time[10] = "ten";
            time[11] = "eleven";
            time[12] = "twelve";
            time[13] = "thirteen";
            time[14] = "fourteen";
            time[15] = "fifteen";
            time[16] = "sixteen";
            time[17] = "seventeen";
            time[18] = "eighteen";
            time[19] = "nineteen";
            time[20] = "twenty";
            time[30] = "thirty";
            time[40] = "forty";
            time[50] = "fifty";
            int m1 = 0;
            int m2 = 0;
            int h1 = 0;
            int h2 = 0;
            if(m > 20){
                m2 = m % 10;
                m1 = m - m2;
                minute = time[m1] + " " + time[m2];
            }else if (m == 0){
                minute = "O'clock";
            } else {
                minute = time[m];
            }

            if(h > 20){
                h1 = 20;
                h2 = h % 10;
                if (h2 != 0) {
                    hour = time[h1] + " " + time[h2];
                } else {
                    hour = time[h1];
                }
            }else {
                hour = time[h];
            }

            System.out.println("时间为："+hour+" "+minute);
        }else {
            System.out.println("时间输入错误！");
        }
    }
}
