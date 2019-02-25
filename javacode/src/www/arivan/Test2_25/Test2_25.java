package www.arivan.Test2_25;
import java.util.Scanner;

public class Test2_25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[]{3,8,1,0,9,5,4,7,6,2};
//        Selection.sorting(arr);
//        //int[] arr1 = Selection.sorting(arr);
//        for(int i : arr){
//            System.out.println(i);
//        }
        Selection selection = new Selection();
        System.out.println(selection.selectionProblem(arr, n));

    }
}

class Selection {

    //选择问题selectionProblem
    public int selectionProblem(int[] arr, int n) {
        sorting(arr);
        return arr[n-1];
    }

        public static void sorting(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] < arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}


//class Selection {
//
//    //选择问题selectionProblem
//    public int selectionProblem(int[] arr, int n){
//        int[] arr1 = new int[n];
//        for (int i = 0; i < arr1.length; i++) {
//            arr1[i] = arr[i];
//        }
//        sorting(arr1);
//        int index = n;
//        while (index < arr.length) {
//            int i = 1;
//            if (arr[index] > arr1[n-i]){
//                i++;
//                while (i <= n){
//                    if(arr[index] > arr1[n-i]){
//                        int temp = arr[index];
//                        arr[index] = arr1[n-i+1];
//                        arr1[n-i+1] = temp;
//                    }else if (arr[index] == arr1[n-i]){
//                        int temp = arr[index];
//                        arr[index] = arr1[n-i+1];
//                        arr1[n-i+1] = temp;
//                    } else {
//                        i++;
//                    }
//                }
//            }
//            index++;
//        }
//        return arr1[n-1];
//    }
//
//    public static void sorting(int[] arr){
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i+1; j < arr.length; j++) {
//                if (arr[i] < arr[j]){
//                    int temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//        //return arr;
//    }
//}