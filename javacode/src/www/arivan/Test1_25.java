package www.arivan;
import java.util.Scanner;

public class Test1_25 {
    public static void main(String[] args){
//        int[] arr = Array.getPrime(10000);
//        Array.printArr(arr);
        Array.fenjie();

    }
}

//求出区间[a,b]中所有整数的质因数分解。
class Array {
    public static void fenjie(){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[] arr = Array.getPrime(10000);
        for (int i = m; i <= n; i++) {
            for (int j = 0; j < arr.length; j++) {
                int num = 0;
                for (int k = 0; k < arr.length; k++) {
                    if(arr[j] * arr[k] == i && arr[j] != 1){
                        num = 1;
                        System.out.println(i+"="+arr[j]+"*"+arr[k]);
                        break;
                    }else if(arr[j] * arr[k] == i && arr[j] == 1){
                        num = 1;
                        System.out.println(i+"="+i);
                        break;
                    }
                }
                if(num == 1){
                    break;
                }
            }
        }
    }

    public static int[] getPrime(int n){ //找出1-n的素数
        int a = 0;
        int[] arr = new int[n];
        for(int i = 1; i <= n; i++){
            if(prime(i)){
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

    public static void printArr(int[] arr){
        for(int i : arr){
            System.out.println(i);
        }
    }

    public static boolean prime(int n){ //判断素数
        for (int i = 2; i <= n/2; i++) {
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}