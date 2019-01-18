package www.arivan.Test1_18;
import java.util.Scanner;

public class Test1_18 {
    public static void main(String[] args){
        Array.Huffuman();
        //Array.empress(4);
//        int[][] arr = new int[][]{{1,1,2,3},{1,2,3,4}};
//        System.out.println(Array.hang(arr,1,0));
    }
}

class Array {
//    Huffman树在编码中有着广泛的应用。在这里，我们只关心Huffman树的构造过程。
//            　　给出一列数{pi}={p0, p1, …, pn-1}，用这列数构造Huffman树的过程如下：
//            　　1. 找到{pi}中最小的两个数，设为pa和pb，将pa和pb从{pi}中删除掉，
//                  然后将它们的和加入到{pi}中。这个过程的费用记为pa +pb。
//            　　2. 重复步骤1，直到{pi}中只剩下一个数。
//            　　在上面的操作过程中，把所有的费用相加，就得到了构造Huffman树的总费用。
//            　　本题任务：对于给定的一个数列，现在请你求出用该数列构造Huffman树的总费用。

    public static void Huffuman(){   //Huffuman树
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = entering(n);
//        arrayPrint(arr,0);
//        System.out.println();
//
//        intArraySorting(arr); //数组排序
//        arr[1] += arr[0];
//        arrayPrint(arr,1);
        int m = 1;
        int m1 = 0;
        int sum = 0;
        while(n > 1){
            intArraySorting(arr); //数组排序
            arr[m] += arr[m1];  //将最小的两个加起来
            sum += arr[m];  //计算费用
            n--;
            m++;
            m1++;
        }
        System.out.println(sum);

    }

//    给定一个n*n的棋盘，棋盘中有一些位置不能放皇后。现在要向棋盘中放入n个黑皇后和n个白皇后，
//    使任意的两个黑皇后都不在同一行、同一列或同一条对角线上，任意的两个白皇后都不在同一行、
//    同一列或同一条对角线上。问总共有多少种放法？n小于等于8。
    public static void empress(int n){ //皇后问题
        int whiteEmpress = n; //白皇后个数
        int blackEmpress = n; //黑皇后个数
        int[][] arr = entering2(n);
        //arrayPrint(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == 1){

                }
            }
        }
    }

    public static boolean hang(int[][] arr, int n, int m){ //判断二维数组第n行中某元素是否在本行有相同的元素
        int num = 0;
        for (int i = 0; i < arr[n].length; i++) {
            if(arr[n][i] == arr[n][m]){
                num++;
            }
        }
        if(num > 1){
            return false;
        }else {
            return true;
        }
    }

    public static boolean lie(int[][] arr, int n, int m){ ////判断二维数组第n行中某元素是否在本列有相同的元素
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i][m] == arr[n][m]){
                num++;
            }
        }
        if(num > 1){
            return false;
        }else {
            return true;
        }
    }

    public static int[] entering(int n){ //给一维数组赋值
        int[] arr = new int[n];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static int[][] entering2(int n){ //给二维数组赋值
        int[][] arr = new int[n][n];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        return arr;
    }

    public static int[] intArraySorting(int[] arr){ //数组排序
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void arrayPrint(int[] arr, int num){ //数组输出
        for (int i = num; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void arrayPrint(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void arrayPrint(char[] arr, int num){
        for (int i = num; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void arrayPrint(long[] arr, int num){
        for (int i = num; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void arrayPrint(String[] arr, int num){
        for (int i = num; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void arrayPrint(double[] arr, int num){
        for (int i = num; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

}