package www.arivan.Test1_17;
import java.util.Scanner;

public class Test1_17 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入n、m的值(n>=1  m<=26)：");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if (n >= 1 && m <= 26) {
            Math2.letterForm(n,m);
        } else {
            System.out.println("输入错误！");
        }

        //Math2.zeroOneString();

//        System.out.println("请输入要判断的年份：");
//        int n = scanner.nextInt();
//        Math2.judgeIsLeapYaer(n);

        //System.out.println(Math2.factorial(scanner.nextInt()));

    }
}

class Math2 {
    public static void letterForm(int n, int m){ //输出字母图形
        char[][] arr = new char[n][m];
        int count = 0;
        char start;
        for (int i = 0; i < n; i++) {
            start = 'A';
            for (int j = i; j < m; j++) {
                arr[i][j] = start++;
            }
            start = 'A';
            for (int j = i-1; j >= 0; j--) {
                arr[i][j] = ++start;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void zeroOneString(){ //从小到大的顺序输出32种01串
        for (char i = '0'; i < '2'; i++) {
            for (char j = '0'; j < '2'; j++) {
                for (char k = '0'; k < '2'; k++) {
                    for (char l = '0'; l < '2'; l++) {
                        for (char m = '0'; m < '2'; m++) {
                            System.out.print(i);
                            System.out.print(j);
                            System.out.print(k);
                            System.out.print(l);
                            System.out.print(m);
                            System.out.println();
                        }
                    }
                }
            }
        }
    }

    public static void judgeIsLeapYaer(int n){ //判断闰年
        if(n >= 1990 && n <= 2050){
            if(n%4 == 0 && n%100 != 0 || n%400 == 0){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }else {
            System.out.println("输入错误，输入范围应在(1990-2050)！");
        }
    }
}
