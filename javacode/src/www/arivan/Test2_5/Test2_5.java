package www.arivan.Test2_5;
import java.util.Scanner;

public class Test2_5 {
    public static void main(String[] args){
       // Math1.maxMin();
        Array.newWord();
    }
}

class Math1 {
    public static void maxMin(){ //给定 N 个整数，请你找出这 N 个数中最大的那个和最小的那个。
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n >= 1 && n <= 10000){
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if(arr[i] > max){
                    max = arr[i];
                }
            }
            System.out.print(max+" ");

            int min = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if(arr[i] < min){
                    min = arr[i];
                }
            }
            System.out.print(min);
        }else {
            System.out.println("输入错误！");
        }
    }
}

class Array {
    public static void newWord(){ //算法提高 新建Microsoft Word文档
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[1500];
        int n = scanner.nextInt();
        for(int i=0; i<n; i++){
            String string = scanner.next();
            if(string.charAt(0) == 'N'){//New
                for(int j=0; j<n; j++){
                    if(arr[j] == 0){
                        arr[j] = 1;
                        System.out.println(j+1);
                        break;
                    }
                }
            }else{//Delete
                int a = scanner.nextInt();
                if(arr[a-1] == 1){
                    arr[a-1] = 0;
                    System.out.println("Successful");
                }else if(arr[a-1] == 0){
                    System.out.println("Failed");
                }
            }
        }
    }
}