package www.arivan.Test2_7;
import java.util.Scanner;

public class Test2_7 {
    public static void main(String[] args) {
        //A.run();
        B.data();
    }
}

class A {
//    一共有5个红领巾，编号分别为A、B、C、D、E，老奶奶被他们其中一个扶过了马路。
//
//            　　五个红领巾各自说话：
//
//            　　A ：我和E都没有扶老奶奶
//
//　　B ：老奶奶是被C和E其中一个扶过大街的
//
//　　C ：老奶奶是被我和D其中一个扶过大街的
//
//　　D ：B和C都没有扶老奶奶过街
//
//　　E ：我没有扶老奶奶
//
//
//　　已知五个红领巾中有且只有２个人说的是真话，请问是谁扶这老奶奶过了街？
//
//            　　若有多个答案，在一行中输出，编号之间用空格隔开。

    public static void run(){
        int num;
        for(int i = 1; i <= 5; i++){
            num = 0;
            if(i!=1 && i!=5){
                num++;
            }
            if(i==3 || i==5){
                num++;
            }
            if(i==3 || i==4){
                num++;
            }
            if(i!=2 && i!=3){
                num++;
            }
            if(i != 5){
                num++;
            }
            if(num == 2){
                System.out.print((char)(i-1+'A')+" ");
            }
        }
    }
}

class B {
//    已知2011年11月11日是星期五，问YYYY年MM月DD日是星期几？注意考虑闰年的情况。
//    尤其是逢百年不闰，逢400年闰的情况。
    public static void data(){
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        int mm[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int sum = 0;
        if (y >= 2018) {
            for (int i = 2018; i < y; i++) {
                if (run(i)) {
                    sum += 366;
                }else {
                    sum += 365;
                }
            }
            for (int i = 0; i < m; i++) {
                sum += mm[i];
            }
            sum += d;
            if (m > 2 && run(y)) {
                sum++;
            }
            if (sum % 7 == 0) {
                System.out.println(7);
            } else {
                System.out.println(sum % 7);
            }
        }
        else {
            for (int i = y + 1; i < 2018; i++) {
                if (run(i)) {
                    sum += 366;
                }else {
                    sum += 365;
                }
            }
            for (int i = m + 1; i <= 12; i++) {
                sum += mm[i];
            }
            sum += mm[m] - d;
            if (m <= 2 && run(y)) {
                sum++;
            }
            if (sum % 7 == 0) {
                System.out.println(7);
            }else {
                System.out.println(7 - sum % 7);
            }
        }
    }
    private static boolean run(int i) {
        if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }
}