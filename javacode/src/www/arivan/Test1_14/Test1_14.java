package www.arivan.Test1_14;
import java.util.Scanner;

//序列求和
//public class Test1_14 {
//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入要求和的数：");
//        int n = scanner.nextInt();
//        System.out.println(add(n));
//    }
//    public static long add(int n){
//        if(n >= 1 && n <= 1000000000){
//            long sum = 0;
//            for(int i = 0; i <=n; i++){
//                sum += i;
//            }
//            return sum;
//        }else {
//            return 0;
//        }
//    }
//}

//A + B问题
//public class Test1_14{
//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("请输入A的值：");
//            int A = scanner.nextInt();
//            if(A >= -10000 ){
//                System.out.println("请输入B的值：");
//                int B = scanner.nextInt();
//                if(B <= 10000){
//                    System.out.println("A和B的和为："+(A+B));
//                    break;
//                }else{
//                    System.out.println("输入错误！");
//                }
//            }else {
//                System.out.println("输入错误！");
//            }
//        }
//    }
//}

//数列冒泡排序
public class Test1_14 {
    public static void main(String[] args) {
        int[] arr = new int[]{6,3,5,2,1,9,8,0,7,4};
        sorting(arr);
    }
    public static void sorting(int[] arr){
        int max = arr[0];
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                count++;
            }
        }
        System.out.println(count);
        for(int a : arr){
            System.out.println(a);
        }
    }
}