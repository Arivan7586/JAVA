package Test6_13;

import java.util.Scanner;

public class practice6_13 {

    public static void main(String[] args) {
//        Solution.solution();

        Solution1.solution();

    }
}

//统计每个月兔子的总数

/**
 * 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生
 * 一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
 */
class Solution {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            System.out.println(getTotalCount(n));
        }
    }
    private static int getTotalCount(int monthCount) {
        if (monthCount == 1 || monthCount == 2) {
            return 1;
        }
        return  getTotalCount(monthCount-1) +
                getTotalCount(monthCount - 2);
    }
}

//最难的问题

/**
 * NowCoder生活在充满危险和阴谋的年代。为了生存，他首次发明了密码，用于军队的消息传递。
 * 假设你是军团中的一名军官，需要把发送来的消息破译出来、并提供给你的将军。
 * 消息加密的办法是：对消息原文中的每个字母，分别用该字母之后的第5个字母替换（
 * 例如：消息原文中的每个字母A 都分别替换成字母F），其他字符不 变，
 * 并且消息原文的所有字母都是大写的。密码中的字母与原文中的字母对应关系如下。
 * 密码字母：A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 * 原文字母：V W X Y Z A B C D E F G H I J K L M N O P Q R S T U
 */
class Solution1 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String input = in.nextLine();
            System.out.println(translate(input));
        }
    }
    private static String translate(String str) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
                int value = str.charAt(i) - 5 - 65;
                char c;
                if (value < 0) {
                    c = (char) (26 + value + 65);
                } else {
                    c = (char) (value + 65);
                }
                res.append(c);
            } else {
                res.append(str.charAt(i));
            }
        }
        return String.valueOf(res);
    }
}