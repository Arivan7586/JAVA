package Test8_16;

import java.util.*;

public class Practice8_16 {

    public static void main(String[] args) {

        Solution.solution();

        Solution1 solution1 = new Solution1();
        int[] pushA = {1,2,3,4,5};
        int[] popA = {3,2,1,5,4};
        System.out.println(solution1.IsPopOrder(pushA,popA));
        System.out.println(solution1.IsPopOrder(new int[]{1},new int[]{2}));


        Solution2.maxDepth();

        System.out.println(new Integer(2) == 2);
        System.out.println(new Integer(2) == new Integer(2));
        System.out.println(Integer.valueOf(2) == Integer.valueOf(2));
        System.out.println(Integer.valueOf(1024) == Integer.valueOf(1024));
        System.out.println(Integer.valueOf(2).intValue() == 2);
        System.out.println(new Integer(2).equals(new Integer(2)));
        System.out.println(new Float(2.2).equals(new Float(2.20)));

    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}


class Solution {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i < a.length; i++) {
            a[i] = in.nextInt();
        }
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            HashSet<Integer> set = new HashSet<>();
            for (int j = l; j <= r; j++) {
                set.add(a[j]);
            }
            System.out.println(set.size());
        }
        in.close();
    }
}

//栈的压入、弹出序列
class Solution1 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while (i < pushA.length) {
            if (stack.isEmpty()) {
                stack.push(pushA[i++]);
            }
            if (stack.peek() == popA[j]) {
                stack.pop();
                j++;
            } else {
                if (i >= pushA.length) {
                    break;
                }
                stack.push(pushA[i++]);
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != popA[j++]) {
                return false;
            }
        }
        return true;
    }
}

//获取n维数组的最大深度
class Solution2 {
    public static void maxDepth() {
        Scanner in = new Scanner(System.in);
        String value = in.nextLine();
        int maxDepth = 0;
        int sum = 0;
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (c == '[') {
                sum++;
            } else if (c == ']') {
                sum--;
            }
            maxDepth = Math.max(maxDepth,sum);
        }
        System.out.println(maxDepth);

//        value = value.replaceAll(",", "");
//        value = value.replaceAll(" ", "");
//        Stack<Character> stack = new Stack<>();
//        int maxDepth = 0;
//        for (int i = 0; i < value.length(); i++) {
//            char c = value.charAt(i);
//            if (stack.isEmpty() && c == '[') {
//                stack.push(c);
//            } else {
//                if (c == ']') {
//                    stack.pop();
//                } else if (c == '[') {
//                    stack.push(c);
//                }
//                maxDepth = Math.max(stack.size(), maxDepth);
//            }
//        }
//        System.out.println(maxDepth);
    }
}