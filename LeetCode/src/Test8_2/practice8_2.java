package Test8_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class practice8_2 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.Permutation("abc"));

    }
}

//字符串的排列（剑指offer）
class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null) {
            return list;
        }
        char[] arr = str.trim().toCharArray();
        add(arr,0,list,"");
        Collections.sort(list);
        return list;
    }

    private void add(char[] arr, int index, ArrayList<String> list, String string) {
        if (index >= arr.length) {
            if (!string.equals("") && !list.contains(string)) {
                list.add(string);
            }
            return;
        }
        for (int i = index; i < arr.length; i++) {
            String value = string + arr[i];
            swap(arr,index,i);
            add(arr,index+1,list,value);
            swap(arr,index,i);
        }
    }
    private void swap(char[] arr , int i, int j) {
        if (i != j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}


//包含min函数的栈（剑指offer）
class Solution1 {
    private Stack<Integer> stack = new Stack<>();

    //每次添加两个值，先添加元素，再添加当前栈的最小值
    public void push(int node) {
        if (stack.isEmpty()) {
            stack.push(node);
            stack.push(node);
        } else {
            int value = stack.peek();
            stack.push(node);
            value = node < value ? node : value;
            stack.push(value);
        }
    }

    public void pop() {
        this.stack.pop();
        this.stack.pop();
    }

    public int top() {
        return this.stack.get(stack.size()-2);
    }

    public int min() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return 0;
    }
}