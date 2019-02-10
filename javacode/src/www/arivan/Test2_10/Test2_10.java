package www.arivan.Test2_10;
import java.util.Scanner;

public class Test2_10 {
    public static void main(String[] args) {
        Math1.tenToEight();
    }
}

class Math1{
//    编写函数，其功能为把一个十进制数转换为其对应的八进制数。程序读入一个十进制数，
//    调用该函数实现数制转换后，输出对应的八进制数。
    public static void tenToEight(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[32];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
        int num = n;
        int i = 0;
        while (num >= 8){
            arr[i] = num%8;
            num /= 8;
            i++;
        }
        if (num < 8){
            arr[i] = num;
        }

        int j = arr.length-1;
        while (arr[j] == 0){
            j--;
        }
        while (j >= 0){
            System.out.print(arr[j]);
            j--;
        }
    }
}