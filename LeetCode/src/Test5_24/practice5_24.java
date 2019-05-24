package Test5_24;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class practice5_24 {

    public static void main(String[] args) {
//        Solution.solution();
//        Solution1.solution();
        Solution2.solution();
    }
}

class Solution {
    /**
     * 买苹果
     *
     * 小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装
     * （每袋不可以拆分）。可以是小易现在只想购买n个苹果，小易想购买尽量少的袋数
     * 方便携带。如果不能购买恰好n个苹果，小易将不会购买
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n < 6) {
            System.out.println(-1);
        } else if (n%8 == 0) {
            System.out.println(n/8);
        } else {
            for (int i = 0; i <= n/6 + 1;i++) {
                int value = i * 6;
                if (n == value) {
                    System.out.println(i);
                    return;
                } else if (value > n) {
                    System.out.println(-1);
                    break;
                }
                for (int j = 1; j <= n/8 + 1; j++) {
                    value += 8;
                    if (n == value) {
                        System.out.println(i+j);
                        return;
                    } else if (value > n) {
                        break;
                    }
                }
            }
        }
    }
}

class Solution1 {
    /**
     * 删除公共字符
     *
     * 输入两个字符串，从第一个字符串中删除第二个字符串中所有的字符。
     * 例如，输入”They are students.”和”aeiou”，
     * 则删除之后的第一个字符串变成”Thy r stdnts.”
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            String value = String.valueOf(str1.charAt(i));
            if (!str2.contains(value)) {
                str.append(value);
            }
        }
        System.out.println(str);
    }
}

class Solution2 {
    /**
     * 神奇的口袋
     *
     * 有一个神奇的口袋，总的容积是40，用这个口袋可以编出一些物品，这些物品的总体积
     * 必须是40.现在有n个想要的到的物品，每个物品的体积分别是a1,a2,a3……an。可以从
     * 这些物品中选择一些，如果选出的物体的总体积是40，那么利用这个神奇的口袋，
     * 就可以得到这些物品，现在的问题是，有多少种不同的选择物品的方式。
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(count(arr,0,40));
    }
    private static int count(int[] arr, int i, int num) {
        if (num == 0) {
            return 1;
        } else if (i == arr.length-1) {
            if (num == arr[i]) {
                return 1;
            } else {
                return 0;
            }
        } else if (arr[i] > num) {
            return count(arr,i+1,num);
        } else {
            return count(arr,i+1,num-arr[i]) +
                    count(arr,i+1,num);
        }
    }
}

class Solution3 {
    /**
     * 用两个栈实现队列
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        if (stack1.isEmpty()) {
            stack1.push(node);
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(node);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }
    }

    public int pop() {
        return stack1.pop();
    }
}