package www.arivan.Test1_22;
import java.awt.geom.Area;
import java.util.Scanner;

public class Test1_22 {
    public static void main(String[] args){
        char a = '1';
        char b = '2';
        String s = "abcd";
        String s1 = "abcca";
        //System.out.println(Array.swapString(s,3,4));
        //System.out.println(Array.judgeString(s1));

        //Array.getHuiWen();

        A.squarenessArea();
    }
}

//回文串，是一种特殊的字符串，它从左往右读和从右往左读是一样的。
//        现在给你一个串，它不一定是回文的，请你计算最少的交换次数使得该串变成一个完美的回文串。
//        　　交换的定义是：交换两个相邻的字符
//        　　例如mamad
//        　　第一次交换 ad : mamda
//        　　第二次交换 md : madma
//        　　第三次交换 ma : madam (回文！完美！)

class Array {
    public static String swapString(String str, int m, int n){ //交换两个相邻的字符
        m -= 1;
        n -= 1;
        char[] arr = str.toCharArray();
        char temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
        return new String(arr);
    }

    public static boolean judgeString(String str){ //判断当前字符串是否是回文串
        char[] c = str.toCharArray();
        int left = 0;
        int right = c.length-1;
        while (left < right){
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            left++;
            right--;
        }
        String str2 = new String(c);
        if(str.equals(str2)){
            return true;
        }else {
            return false;
        }
    }

    public static void getHuiWen(){
        boolean b = true; //是否匹配
        char x1 = 0 ;//x1记录字符串长度为奇数且第一次未匹配，x2记录第二次未匹配。
        int sum = 0;//交换次数
        Scanner sc = new Scanner(System.in);
        char[] charArray = sc.nextLine().toCharArray();//输入的字符串转化为字符数组
        //i表示从左往右未匹配字符的下标
        //j表示从右往左未匹配的字符下标
        for (int i = 0; i < charArray.length/2; i++) {
            //如果不能能匹配（字符串长度为奇数）
            //从右向左找与左边下标为i的字符相匹配的
            for (int j = i; j < charArray.length-1-i; j++) {
                //如果匹配
                if(charArray[i] == charArray[charArray.length-1-j]){
                    b = true;
                    //如果左右不对称则交换
                    if(i!=j){
                        char a = charArray[charArray.length-1-j];
                        for (int k = j; k > i; k--) {
                            sum++;
                            charArray[charArray.length-1-k] = charArray[charArray.length-k];
                        }
                        charArray[charArray.length-1-i] = a;
                    }
                    break;//匹配完成就跳出j的循环
                }else{
                    b = false;
                    //若最后一次未匹配到，则保存charArray[i]
                    if(j==charArray.length-i-2 && charArray[i] !=
                            charArray[charArray.length-1-j]){
                        if(x1 == charArray[i]||x1 == 0)
                            x1 = charArray[i];
                    }
                }
            }
            if(b == false){
                if(charArray.length%2==1 && charArray[i]==x1){
                    sum++;
                    char g = charArray[i+1];
                    charArray[i+1] = charArray[i];
                    charArray[i] = g;
                    b = true;
                    i--;//重新匹配charArray[i]；
                }else
                    break;
            }
        }
        if(b)
            System.out.println(sum);
        else
            System.out.println("Impossible");
    }
}

class A {

    public static void squarenessArea(){ //矩形面积交
        Scanner sc = new Scanner(System.in);
        double[] x = new double[4];
        double[] y = new double[4];
        double[] z = new double[4];
        for(int i=0;i<4;i++){
            x[i] = sc.nextDouble();
            y[i] = sc.nextDouble();
        }
        z[0] = Math.max(Math.min(x[0], x[1]),Math.min(x[2], x[3])); //x1
        z[1] = Math.min(Math.max(x[0], x[1]),Math.max(x[2], x[3])); //x2

        z[2] = Math.max(Math.min(y[0], y[1]),Math.min(y[2], y[3])); //y1
        z[3] = Math.min(Math.max(y[0], y[1]),Math.max(y[2], y[3])); //y2
        if(z[0]<z[1]&&z[2]<z[3])
            System.out.printf("%.2f\n",(z[1]-z[0])*(z[3]-z[2]));
        else
            System.out.println("0.00");
    }
}