package www.arivan.Test1_15;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Test1_15 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //System.out.println("请输入十六进制的数（0-9、A-F）：");
        //String string = scanner.nextLine();
//        Swap.sixteenToTen(string);

//        int n = 9;
//        char m = (char) (9 + '0');
//        System.out.println(m);
//        Swap.tenToEigth(84689);

        //Swap.sixteenToEight(string);

        System.out.println("请输入一个十进制的数：");
        long n = scanner.nextLong();
        System.out.println(Swap.tenToSixteen(n));;
    }
}

class Swap {
    public static long sixteenToTen(String str) { //十六进制转换为十进制
        char[] arr = str.toCharArray();
        int n = 0;
        long sum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 'o' || arr[i] == 'x' || arr[i] == 'O' || arr[i] == 'X') {
                break;
            }
            if ((arr[i] >= 48 && arr[i] <= 57) || (arr[i] >= 65 && arr[i] <= 70)) {
                int m = 0;
                switch (arr[i]) {
                    case 'A':
                        m = 10;
                        break;
                    case 'B':
                        m = 11;
                        break;
                    case 'C':
                        m = 12;
                        break;
                    case 'D':
                        m = 13;
                        break;
                    case 'E':
                        m = 14;
                        break;
                    case 'F':
                        m = 15;
                        break;
                    default:
                        m = arr[i] - 48;
                }
                sum = (long) (sum + m * (Math.pow(16, n)));
                n++;
            } else {
                System.out.println("输入错误！");
                break;
            }
        }
        return sum;
        //System.out.println(sum);
    }

    public static void tenToEigth(long n){ //将十进制转换为八进制
        char[] arr = new char[32];
        int i = 0;
        while (n > 0){
            int m = 0;
            if (n >= 8) {
                m = (int) (n % 8);
            } else {
                m = (int) n;
            }
            arr[i] = (char) (m + '0');
            i++;
            n = (n - m) / 8;
        }
        int k = 0;
        int j = arr.length-1;
        while (j > k){
            char temp = arr[k];
            arr[k] = arr[j];
            arr[j] = temp;
            j--;
            k++;
        }
        System.out.print("八进制数为：");
        for(int a = 0; a < arr.length; a++){
            if(arr[a] >= '0' && arr[a] <= '7'){
                System.out.print(arr[a]);
            }
        }
//        System.out.println();
//        String s = new String(arr);
//        System.out.println(s);
    }

    public static void sixteenToEight(String str){ //将十六进制转换为八进制
        long n = sixteenToTen(str);
        tenToEigth(n);
    }

    public static String tenToSixteen(long n){  //将十进制的数转换为十六进制
        char[] arr = new char[32];
        int count = 0;
        int i = arr.length-1;
        while (n > 0) {
            char m = ' ';
            int m1 = 0;
            if (n >= 16) {
                int num = (int) (n % 16);
                switch (num) {
                    case 10:
                        m = 'A';
                        m1 = 10;
                        break;
                    case 11:
                        m = 'B';
                        m1 = 11;
                        break;
                    case 12:
                        m = 'C';
                        m1 = 12;
                        break;
                    case 13:
                        m = 'D';
                        m1 = 13;
                        break;
                    case 14:
                        m = 'E';
                        m1 = 14;
                        break;
                    case 15:
                        m = 'F';
                        m1 = 15;
                        break;
                    default:
                        m = (char) (num + '0');
                        m1 = num;
                        break;
                }
            } else {
                int num1 = (int) n;
                switch (num1) {
                    case 10:
                        m = 'A';
                        m1 = 10;
                        break;
                    case 11:
                        m = 'B';
                        m1 = 11;
                        break;
                    case 12:
                        m = 'C';
                        m1 = 12;
                        break;
                    case 13:
                        m = 'D';
                        m1 = 13;
                        break;
                    case 14:
                        m = 'E';
                        m1 = 14;
                        break;
                    case 15:
                        m = 'F';
                        m1 = 15;
                        break;
                    default:
                        m = (char) (num1 + '0');
                        m1 = num1;
                }
            }
            arr[i] = m;
            count++;
            i--;
            n = (n - m1) / 16;
        }
        char[] arr1 = new char[count];
        int k = 0;
        for(int j = 0; j < arr.length; j++){
            if((arr[j] >= 48 && arr[j] <= 57) || (arr[j] >= 65 && arr[j] <= 70)){
                arr1[k] = arr[j];
                k++;
            }
        }
        String s = new String(arr1);
        return s;
    }
}