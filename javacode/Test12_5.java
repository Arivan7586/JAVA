public class Test12_5{
    public static void main(String[] args){
       //Figure f = new Figure(9);
       Find find = new Find();
    }
}

class Find{
    private int[] arr = new int[]{1,2,3,4,5,6,7,27,46};
    private int left = 0;
    private int right = arr.length - 1;
    private int mid = 0;
    public Find(){
        int n = 0;
        int key = 3;
        while(left < right){
            mid = (left + right) / 2;
            if(arr[mid] < key){
                left = mid + 1;
            }else if(arr[mid] > key){
                right = mid - 1;
            }
            else{
                System.out.println("找到了！下标为："+mid);
                break;
            }
        }
        if(left >= right){
            System.out.println("找不到！");
        }
    }
}

class Figure{
    private int line = 0;
    public Figure(int m){  //构造方法
        int line = m;
        int j = 0;
        int n = 0;
        for(int i = 0; i < line; i++){
            for(j = line - i; j >= 0 ;j--){
                System.out.print(" ");
            }
            for(n = 0; n < i + 1; n++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}