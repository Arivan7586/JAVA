package www.arivan.Test1_10;

import java.util.Scanner;
//1.编写一个算法来判断一个数是不是“快乐数”。
//        一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
//        然后重复这个过程直 到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，
//        那么这个数就是快乐数。
//        示例:
//        输入: 19 输出: true 解释:
//        1^2 + 9^2 = 82
//        8^2 + 2^2 = 68
//        6^2 + 8^2 = 100!
public class Test1_10 {
    public static void main(String[] args){
//        Is_Happy i = new Is_Happy();
//        i.findHappy();

//        Find_Char find = new Find_Char();
//        find.find();

        Sorting s = new Sorting();
        s.sort();
    }
}

class Is_Happy {
    public void findHappy(){
        System.out.println("请输入要判断的数：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num = n;
        while(true){
            num = nextNumber(num);
            if(num == 1){
                System.out.println("这个数是快乐数");
                break;
            }else if(num == 89){
                System.out.println("这个数不是快乐数");
            }
        }
    }
    public static int nextNumber(int n){
        int m = 0;
        while(n > 0){
            m += (n % 10) * (n % 10);
            n = n/10;
        }
        return m;
    }
}

//2.题目描述：给定一个英文字符串，写一段代码找出字符串中首先出现三次的英文字母。
//        输入描述：输入数据一个 字符串，包括字母，数字 输出描述：
//        输出首先出现三次的那个英文字符 示例：
//        输入： Have you ever gone shopping and 输出： e
class Find_Char {
    public void find(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查找的字符串：");
        String str = scanner.nextLine();
        //System.out.println(str);

        char[] data = str.toCharArray();
        int[] arr = new int[250];
        for(int i = 0; i < data.length; i++){
            char c = data[i];
            if (data[i] > 'A' && data[i] < 'Z' || data[i] > 'a' && data[i] < 'z') {

                arr[c]++;
            }
            if(arr[c] == 3){
                System.out.println(c);
                break;
            }
        }
    }
}

//3.题目：有n个人围成一圈，顺序排号。
//        从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问后留下
//        的是原来第几号的哪位
class Sorting {
    public void sort(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入人数：");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = 0;  //零表示在圈子里
        }
        int count = n;
        int num = 1;
        int i = 0;
        while(count > 1){
            if(arr[i] == 0){
                //num++;
                if(num == 3){
                    num = 1;
                    arr[i] = 1;
                    count--;
                }else {
                    num++;
                }
            }
            i++;
            if(i == n){
                i = 0;
            }
        }
        for(int a = 0; a < n; a++){
            if(arr[a] == 0){
                System.out.println("最后留下的人是原来的第"+ (a+1) +"位");
            }
        }
    }
}