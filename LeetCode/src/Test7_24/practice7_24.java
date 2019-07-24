package Test7_24;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class practice7_24 {

    public static void main(String[] args) {

//        Soltuion.solution();

        Solution1.solution();

        int[] arr = new int[]{5,1,0,9,7,4,6,3,2,8};
        Sort.quickSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

//骆驼命名法
class Soltuion {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String value = in.nextLine();
            String[] arr = value.trim().split("_");
            //如果输入的只有一个单词，就无需转换
            if (arr.length == 1) {
                System.out.println(arr[0]);
            } else {
                //输入的单词有多个，进行转换
                StringBuilder sb = new StringBuilder(arr[0]);
                for (int i = 1; i < arr.length; i++) {
                    sb.append(arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1));
                }
                System.out.println(sb);
            }
        }
        in.close();
    }
}

//单词倒排
class Solution1 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.nextLine();
            List<String> list = new ArrayList<>();
            boolean flag = true;
            String word = "";
            for (int i = 0; i < input.length(); i++) {
                char value = input.charAt(i);
                //如果当前字符是字符，则当前单词加上该字母
                if (value >= 'a' && value <= 'z' || value >= 'A' && value <= 'Z') {
                    word += value;
                    if (i == input.length() - 1) {
                        list.add(word);
                    }
                } else {
                    //如果当前字符不是字母，并且当前单词不为空，则将该单词加入List中
                    if (word != "") {
                        list.add(word);
                        word = "";
                    }
                }
            }
            //输出List集合
            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.print(list.get(i));
                if (i != 0) {
                    System.out.print(" ");
                }
            }
        }
        in.close();
    }
}



class Sort {
    /**
     * 非递归快速排序
     * @param arr 待排序数组
     */
    public static void quickSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        int l = 0;
        int r = n - 1;
        int value = findValue(arr,l,r);
        Stack<Integer> stack = new Stack<>();
        if (l < value - 1) {
            stack.push(l);
            stack.push(value - 1);
        }
        if (r > value + 1) {
            stack.push(value + 1);
            stack.push(r);
        }
        while (!stack.isEmpty()) {
            r = stack.pop();
            l = stack.pop();
            value = findValue(arr,l,r);
            if (l < value - 1) {
                stack.push(l);
                stack.push(value - 1);
            }
            if (r > value + 1) {
                stack.push(value + 1);
                stack.push(r);
            }
        }
    }

    //寻找基准元素
    private static int findValue(int[] arr, int l, int r) {
        int randomIndex = (int) (Math.random() * (r - l + 1) + l);
        swap(arr,l,randomIndex);
        int value = arr[l];
        int i = l + 1;
        int j = l;
        int k = r + 1;
        while (i < k) {
            if (arr[i] < value) {
                swap(arr,++j,i++);
            } else if (arr[i] > value) {
                swap(arr,i,--k);
            } else {
                i++;
            }
        }
        swap(arr,l,j);
        return j;
    }

    //交换元素
    private static void swap(int[] arr, int l, int randomIndex) {
        int temp = arr[l];
        arr[l] = arr[randomIndex];
        arr[randomIndex] = temp;
    }

}