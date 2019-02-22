package www.arivan.Test2_22;
import java.util.Scanner;

public class Test2_22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        String str = scanner.nextLine();
        char[] ss = str.toCharArray();
        int c = 0;
        int time = 0;
        int k = len - 1;
        int i, j;
        boolean flag = true;
        for (i = 0; i < k && flag; i++) {
            for (j = k; j >= i; j--) {
                if (i == j) {
                    c++;
                    if (len % 2 == 0 || c > 1) {
                        flag = false;
                        break;
                    }
                    time += Math.abs(len / 2 - i);
                } else if (ss[i] == ss[j]) {
                    for (int z = j; z < k; z++) {
                        ss[z] = ss[z + 1];
                        time++;
                    }
                }
            }
            k--;
            break;
        }
        if(flag) {
            System.out.println(time);
        }else {
            System.out.println("Impossible");
        }
    }
}