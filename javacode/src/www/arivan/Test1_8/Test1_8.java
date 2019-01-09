package www.arivan.Test1_8;
import java.util.Scanner;

//2.题目描述：给定一个英文字符串，写一段代码找出字符串中首先出现三次的英文字母。
//        输入描述：输入数据一个 字符串，包括字母，数字 输出描述：
//        输出首先出现三次的那个英文字符 示例：
//        输入： Have you ever gone shopping and 输出： e
public class Test1_8 {
    public static void main(String[] args){
//        String str = "Have you evre gone shopping and";
//        System.out.println(findThreeTimeChar(str));

        Find f = new Find();

        f.findMan();
    }

    public static char findThreeTimeChar(String str){
        int count = 0;
        char[] data = str.toCharArray();
        int[] arr = new int[250];
        for(int i = 0; i < data.length; i++) {
            char c = data[i];
            if (c > 'a' && c < 'z' || c > 'A' && c < 'Z') {
                arr[c]++;
                if(arr[c] == 3){
                    return c;
                }

            }
        }
        return ' ';
    }
}

//3.题目：有10个人围成一圈，顺序排号。
//        从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问后留下
//        的是原来第几号的那位

//class Find {
//    public static int findMan(){
//        int[] arr = new int[]{0,0,0,0,0,0,0,0,0,0};//给是个人编号
//        int num = 0; //当num=3时，此时的人出局
//         //0代表还在圈子里 ，1代表不在圈子里
//        int i = 0;
//        int m = 10;
//        while(m > 1){
//            if(arr[i] == 0){
//                num++;
//                if(num == 3){
//                    num = 0;
//                    arr[i] = 1;
//                    m--;
//                }
//            }
//            i++;
//            if(i == arr.length){
//                i = 0;
//            }
//        }
//        for(int a = 0; a < arr.length; a++){
//            if(arr[a] == 0){
//                return a+1;
//            }
//        }
//        return 0;
//    }
//}

//4、拓展
class Find {
    public static void findMan(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入排成一圈的人数：");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = 0;  //0代表还在圈子里 ，1代表不在圈子里
        }
        int count = n;
        int num = 0;
        int index = 0;
        while(count > 1){
            if(arr[index] == 0){
                num++;
                if(num == 3){
                    num = 0;
                    arr[index] = 1;
                    count--;
                }
            }
            index++;
            if(index == n){
                index = 0;
            }
        }
        for(int i = 0; i < n; i++){
            if(arr[i] == 0){
                System.out.println("最初排在第"+(i+1)+"的人留下了。");
            }
        }
    }
}