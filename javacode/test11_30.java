public class test11_30{
    public static void main(String[] args) {     

        //testForEach();
        System.out.println();
        sort();
        System.out.println();

    }

    //测试foreach语句
    public static void testForEach() { 
        int[] arr1 = new int[]{0,1,2,3,4,5,6,7,8,9};
        for (int i : arr1) {   
            System.out.print(i+" ");
        }
    } 
    
    //排序练习
    public static void sort(){
        int[] arr1 = new int[]{1,9,5,3,7,4,2,8,6,0};
        int i = 0;
        int start = 0;
        while(start < 9){   //排序
            for(i = start + 1; i < 9; i++){
                if(arr1[i] > arr1[start]){
                    int m = 0;
                    m = arr1[start];
                    arr1[start] = arr1[i];
                    arr1[i] = m;
                }
            }
            start++;
        }
        for(int n : arr1){  //输出
            System.out.println(n);
        }
    }
}