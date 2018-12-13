public class Test12_13{
    public static void main(String[] args){
        int[] arr1 = new int[]{1,2,3,4,5,6};
        int[] arr2 = new int[]{7,8,9,10};
        int[] arr3 = new int[]{2,4,6,8,7,9,2,5,6,4,0,1,2,5,8,6,1};
        //print(arr1);
        // int[] arr3 = new int[]{};
        // arr3 = arrayJoin(arr1, arr2);
        // for(int i : arr3){
        //     System.out.println(i);
        // }
        print(arrayJoin(arr1, arr2));
        System.out.println();
        print(arraySub(arr3, 2, 9));
        System.out.println();
        print(printReversal(arr1));
    }

    //复习for-each语句
    public static void print(int[] arr){
        for(int i:arr){
            System.out.print(i+"、");
        }
    }

    //数组的拼接
    public static int[] arrayJoin(int[] a, int[] b){
        int length = 0;
        length = a.length + b.length;
        int[] arr = new int[length];
        for(int i = 0; i < length; i++){
            if(i < a.length){
                arr[i] = a[i];
            }else{
                arr[i] = b[i - a.length];
            }
        }
        return arr;
    }

    //数组的截取
    public static int[] arraySub(int[] data, int start, int end){
        int length = end - start;
        int[] arr = new int[length];
        for(int i = 0; i < length; i++){
            arr[i] = data[start];
            start++;
        }
        return arr;
    }

    //数组的反转
    public static int[] printReversal(int[] data){
        int end = data.length - 1;
        int[] arr = new int[data.length];
        for(int i = 0; i < data.length; i++){
            arr[i] = data[end];
            end--;
        }
        return arr;
    }
}