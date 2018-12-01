//Java数组章节练习题
public class ArrayUtils{

    //1.计算数组中最大值
    public static int arrayMaxElement(int[] data){
         //TODO 
         int max = 0;
         max = data[0] ;
         for(int i = 1; i < data.length; i++){
            if(data[i] > max){
                max = data[i];
            }
         }
        return max;
    }
    
    //2.计算数组中最小值
    public static int arrayMinElement(int[] data){
        //TODO
        int min = 0;
         min = data[0] ;
         for(int i = 1; i < data.length; i++){
            if(data[i] < min){
                min = data[i];
            }
         }
        return min; 
    }
    
    
    //3.计算数组值之和
    public static int arrayElementSum(int[] data){
        //TODO
        int sum = 0;
        for(int i = 0; i < data.length; i++){
            sum = sum + data[i];
        }
        return sum;
    }
    
    //4.数组拼接
    // A {1,3,5,7,9} B {2,4,6,8,10} -> {1,3,5,7,9,2,4,6,8,10}
    public static int[] arrayJoin(int[] a, int[] b){
        //TODO
        int newLength = a.length + b.length;
        int n = a.length;
        int[] arr = new int[] {0};
        for(int i = 0; i < newLength; i++){
            if(i < n){
                arr[i] = a[i];
            }
            else{
                arr[i] = b[i-n];
            }
        }
        return int[] arr;
    }

    //5.数组截取
    //[start, end)
    // A {1,3,5,7,9} ->(A,1,3) > {3,5}
    public static int[] arraySub(int[] data, int start , int end){
        //TODO

        return null;
    }
    
    //6.数组打印
    public static void printArray(int[] data){
        //TODO
        for(int i : data){
            System.out.println(i);
        }
    }
    
    //7.数组反转
    // 比如：[1,2,3,4] => [4,3,2,1]
    public static void printReversal(int[] data){
        //TODO
        int left = 0;
        int right = 0;
        right = data.length - 1;
        while(left < right){
            int tem = 0;
            tem = data[left];
            data[left] = data[right];
            data[right] = tem;
            left++;
            right--;
        }
        for(int i : data){
            System.out.println(i);
        }
    }
    
    public static void main(String[] args){
        int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
        int[] arr2 = new int[] {11,12,13,14,15,16};
       // System.out.println(arrayMaxElement(arr));      
       //System.out.println(arrayMinElement(arr));
       //System.out.println(arrayElementSum(arr));
       //printArray(arr);    
       //printReversal(arr);
       int[] arr1 =  arrayJoin(arr,arr2);
       for(int a : arr1){
        System.out.println(a);
       }
    }
}