package www.arivan.Test2_18;
import java.util.Scanner;

public class Test2_18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(A.isHappy(scanner.nextInt()));
    }
}

class A {
    //1.编写一个算法来判断一个数是不是“快乐数”。
//        一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
//        然后重复这个过程直 到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，
//        那么这个数就是快乐数。
    public static boolean isHappy(int n){
        int result = n;
        while (true){
            result = getNextMath(result);
            if(result == 1){
                return true;
            }else if (result == 89){
                return false;
            }
        }
    }

    public static int getNextMath(int n){
        int sum = 0;
        while (n > 0){
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}