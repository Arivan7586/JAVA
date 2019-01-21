package www.arivan.Test1_21;
import java.util.Scanner;

public class Test1_21 {
    public static void main(String[] args){
        //Array.chipTest();

        Scanner scanner = new Scanner(System.in);
        //System.out.println(Array.FJstring(scanner.nextInt()));
        //System.out.println(Array.getAn(4));
        //System.out.println(Array.getSn(3,1));

        //Array.change(scanner.nextInt());
        //Array.thousandSay(scanner.nextInt());
        Array.readToChinese(scanner.nextInt());
    }
}

//有n（2≤n≤20）块芯片，有好有坏，已知好芯片比坏芯片多。
//        　　每个芯片都能用来测试其他芯片。用好芯片测试其他芯片时，
//        能正确给出被测试芯片是好还是坏。而用坏芯片测试其他芯片时，会随机给出好或是坏的测试结果
//        （即此结果与被测试芯片实际的好坏无关）。
//        　　给出所有芯片的测试结果，问哪些芯片是好芯片。

class Array {
    public static void chipTest(){  //芯片测试问题
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n >= 2 && 2 <= 20){
            int[][] arr = new int[n][n];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < arr.length; i++) {
                int t = 0; //代表好芯片的次数
                int f = 0; //代表坏芯片的次数
                for (int j = 0; j < arr[i].length; j++) {
                    if(arr[i][j] == 1){
                        t++;
                    }
                    if(arr[i][j] == 0){
                        f++;
                    }
                }
                if(t > f){ //如果芯片是好的，则显示1的次数肯定大于0
                    System.out.println((i+1)+" ");
                }
            }
        }else {
            System.out.println("输入错误！正确范围是(2-20)");
        }
    }

//    FJ在沙盘上写了这样一些字符串：
//            　　A1 = “A”
//            　　A2 = “ABA”
//            　　A3 = “ABACABA”
//            　　A4 = “ABACABADABACABA”
//            　　… …
//            　　找出其中的规律并写数列AN

    public static String FJstring(int n){  //递归法
        String str = null;
        if(n <= 26 && n > 1){
            char c = (char)(n+64);
            String str1 = new String(String.valueOf(c));
            str = FJstring(n-1)+str1+FJstring(n-1);
            return str;
        }
        if(n == 1){
            char c = (char)(n+64);
            str = new String(String.valueOf(c));
            return str;
        }else {
            return "输入错误！";
        }
    }

//    An=sin(1–sin(2+sin(3–sin(4+...sin(n))...)
//            　　Sn=(...(A1+n)A2+n-1)A3+...+2)An+1
//    请你帮助FJ打印出Sn的完整表达式
    public static String getAn(int n){  //取得An
        String An = "";
        String st = "sin(";
        String s = null;
        for (int i = 1; i <= n; i++) {
            if(i == 1){
                s = "";
            }else if(i > 1 && i%2 == 0){
                s = "-";
            }else if(i > 1 && i%2 == 1){
                s = "+";
            }
            An = An + (s+st+i);
        }
        String s2 = "";
        for(int i = 0; i < n; i++){
            s2 += ")";
        }
        An += s2;
        return An;
    }
    public static String getSn(int n,int i){
        if(n <= 1){
            return getAn(n)+"+"+i;
        }
        return "("+getSn(n-1,i+1)+")"+getAn(n)+"+"+i;
    }

//    当他输入12 3456 7009时，会给出相应的念法：
//            　　十二亿三千四百五十六万七千零九
//　　用汉语拼音表示为
//　　shi er yi san qian si bai wu shi liu wan qi qian ling jiu

    public static void readToChinese(int n){
        if(n < 10000){
            thousandSay(n);
            System.out.println();
        }else if(n < 100000000){
            int n1 = n / 10000;
            int n2 = n % 10000;
            if(n2 == 0){
                thousandSay(n1);
                System.out.print("wan");
                System.out.println();
            }else {
                thousandSay(n1);
                System.out.print("wan ");
                thousandSay(n2);
                System.out.println();
            }
        }else if(n < 2000000000){
            int n1 = n / 100000000;
            int n2 = (n/10000) % 10000;
            int n3 = n % 10000;
            thousandSay(n1);
            System.out.print("yi(亿) ");
            thousandSay(n2);
            System.out.print("wan ");
            thousandSay(n3);
            System.out.println();
        }else if(n == 2000000000){
            System.out.println("er yi()亿");
            System.out.println();
        }else {
            System.out.println("输入错误，正确范围是（0-20 0000 0000）");
        }
    }

    public static void thousandSay(int n){
        String[] arr = new String[]{"ling ","yi ","er ","san ","si ","wu ","liu ","qi ","ba ","jiu "};
        String shi = "shi ";
        String bai = "bai ";
        String qian = "qian ";
        int num = n;
        if(n < 10){
            System.out.print(arr[n]);
        }else if(n < 100){
            int a = n / 10;
            int b = n % 10;
            if(b == 0){
                System.out.print(arr[a]+shi);
            }else if(a == 1){
                System.out.print(shi+arr[b]);
            } else {
                System.out.print(arr[a]+shi+arr[b]);
            }
        }
        else if(n < 1000){
            int a = n / 100;
            int b = (n / 10) % 10;
            int c = n % 10;
            if(b == 0 && c == 0){
                System.out.print(arr[a]+bai);
            }else if(b == 0 & c != 0){
                System.out.print(arr[a]+bai+arr[0]+arr[c]);
            }else if(b != 0 && c == 0){
                System.out.print(arr[a]+bai+arr[b]+shi);
            }else {
                System.out.print(arr[a]+bai+arr[b]+shi+arr[c]);
            }
        }else if(n < 10000){
            int a = n / 1000; //表示千位
            int b = (n / 100) % 10; //表示百位
            int c = (n / 10) % 10; //表示十位
            int d = n % 10; //表示个位
            if(b == c && c == d && d == 0){
                System.out.print(arr[a]+qian);
            }else if (b == 0 && c != 0 & d != 0){
                System.out.print(arr[a]+qian+arr[0]+arr[c]+shi+arr[d]);
            }else if(b == 0 && c == 0 && d != 0){
                System.out.print(arr[a]+qian+arr[0]+arr[d]);
            }else if (b == 0 && c != 0 && d == 0){
                System.out.print(arr[a]+qian+arr[0]+arr[c]+shi);
            }else if(c == 0 && d == 0){
                System.out.print(arr[a]+qian+arr[b]+bai);
            }else if (c == 0 && d != 0){
                System.out.print(arr[a]+qian+arr[b]+bai+arr[0]+arr[d]);
            }else if(d == 0){
                System.out.print(arr[a]+qian+arr[b]+bai+arr[c]+shi);
            }else {
                System.out.print(arr[a]+qian+arr[b]+bai+arr[c]+shi+arr[d]);
            }
        }
    }

    public static void change(int n){ //借鉴版 数的读法
        int i,j;
        String[] c={"ling ","yi ","er ","san ","si ","wu ","liu ","qi ","ba ","jiu "};
        String[] d={"","shi ","bai ","qian ","wan ","shi ","bai ","qian ","yi ","shi ","bai "};
        String ss=n+"";
        String buffer=new String();
        boolean b=true; //第一次出现零
        for ( i=0;i<ss.length();i++){
            for( j=0;j<=9;j++)
                if(ss.charAt(i)==j+'0')
                    break;
            if((ss.length()+2)%4==0&&i==0&&j==1){
                buffer+=d[ss.length()-i-1];
            }else if(i!=ss.length()-1&&j==0){
                if(b){
                    buffer+=c[j];
                    b=false;
                }
            }else if(i==ss.length()-1&&j==0){
                if(!b)
                    buffer=buffer.substring(0,buffer.length()-5) ;//如果最后一个也为0，则去掉之前添加的 ling
            }else{
                buffer+=c[j]+d[ss.length()-i-1];
                b=true;
            }
        }
        System.out.println(buffer);
    }
}
