package Test8_10;

import java.util.*;

public class practice8_10 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.backspaceCompare("ab##","c#d#"));

        Solution1.solution();

        Solution2.solution();

        Solution3.solution();

    }
}

//比较含退格的字符串
class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = addToStack(S);
        Stack<Character> stack2 = addToStack(T);
        if (stack1.size() != stack2.size()) {
            return false;
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.pop() != stack2.pop()) {
                return false;
            }
        }
        return true;
    }
    private Stack<Character> addToStack(String value) {
        Stack<Character> stack = new Stack<>();
        if (value == null || value.length() == 0) {
            return stack;
        }
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        return stack;
    }
}

//时钟
class Solution1 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                String time = in.next();
                System.out.println(run(time));
            }
        }
        in.close();
    }
    private static String run(String time) {
        if (time == null || time.equals("")) {
            return time;
        }
        String hour = time.split(":")[0];
        String minute = time.split(":")[1];
        String second = time.split(":")[2];
        if (Integer.parseInt(hour) >= 24) {
            hour = "0" + hour.substring(1);
        }
        if (Integer.parseInt(minute) >= 60) {
            minute = "0" + minute.substring(1);
        }
        if (Integer.parseInt(second) >= 60) {
            second = "0" + second.substring(1);
        }
        return hour + ":" + minute + ":" + second;
    }
}

//会话列表
class Solution2 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int T = in.nextInt();
            for (int i = 0; i < T; i++) {
                int N = in.nextInt();
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 0; j < N; j++) {
                    int data = in.nextInt();
                    if (list.contains(data)) {
                        list.remove(list.indexOf(data));
                    }
                    list.add(data);
                }
                for (int j = list.size() - 1; j >= 0; j--) {
                    System.out.print(list.get(j));
                    if (j != 0) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }

        }
        in.close();
    }
}

//字符迷阵
class Solution3 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int row = in.nextInt();
            int col = in.nextInt();
            String[] datas = new String[row];
            for (int j = 0; j < row; j++) {
                datas[j] = in.next();
            }
            String word = in.next();
            System.out.println(wordNums(datas,word));
        }
        in.close();
    }
    private static int wordNums(String[] datas, String word) {
        if (word == null || word.equals("")) {
            return 0;
        }
        int nums = 0;
        char flag = word.charAt(0);
        int length = word.length();
        //向右扫描
        if (length <= datas[0].length()) {
            for (int i = 0; i < datas.length; i++) {
                for (int j = 0; j <= datas[i].length() - length; j++) {
                    char c = datas[i].charAt(j);
                    if (c != flag) {
                        continue;
                    }
                    if (word.equals(datas[i].substring(j,j+length))) {
                        nums++;
                    }
                }
            }
        }
        //向下扫描
        if (length <= datas.length) {
            for (int i = 0; i <= datas.length - length; i++) {
                for (int j = 0; j < datas[i].length(); j++) {
                    char c = datas[i].charAt(j);
                    if (c != flag) {
                        continue;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int k = i; k < i + length; k++) {
                        sb.append(datas[k].charAt(j));
                    }
                    if (word.equals(sb + "")) {
                        nums++;
                    }
                }
            }
        }
        //向右下扫描
        if (length <= datas.length && length <= datas[0].length()) {
            for (int i = 0; i <= datas.length - length; i++) {
                for (int j = 0; j <= datas[i].length() - length; j++) {
                    char c = datas[i].charAt(j);
                    if (c != flag) {
                        continue;
                    }
                    //向右下
                    StringBuilder value = new StringBuilder();
                    for (int k = 0; k < length ; k++) {
                        value.append(datas[i+k].charAt(j+k));
                    }
                    if (word.equals(value + "")) {
                        nums++;
                    }
                }
            }
        }
        return nums;
    }
}
