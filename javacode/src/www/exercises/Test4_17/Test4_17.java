package www.exercises.Test4_17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Test4_17 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numJewelsInStones("aA","aAAbbbb"));
        System.out.println(solution.numJewelsInStones("z","ZZ"));

        String[] arr = new String[]{"ac","ad","aa","af","ef"};
        Arrays.sort(arr);
        for (String s : arr) {
            System.out.print(s+" ");
        }

        System.out.println("---------------");
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // 返回 1
        System.out.println(queue.pop());  // 返回 1
        System.out.println(queue.empty()); // 返回 false

    }
}

class Solution {
    /**
     *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。
     *  S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，
     * 因此"a"和"A"是不同类型的石头
     * @param J 宝石
     * @param S 石头
     * @return 返回宝石个数
     */
    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null) {
            return 0;
        }
        int value = 0;
        for (int i = 0; i < J.length(); i++) {
            value += sumOfJewel(J.charAt(i),S);
        }
        return value;
    }
    public int sumOfJewel(char jewel, String stone) {
        int count = 0;
        for (int i = 0; i < stone.length(); i++) {
            if (stone.charAt(i) == jewel) {
                count++;
            }
        }
        return count;
    }
}

class MyQueue {
    /**
     * 使用栈实现队列的下列操作：
     *
     * push(x) -- 将一个元素放入队列的尾部。
     * pop() -- 从队列首部移除元素。
     * peek() -- 返回队列首部的元素。
     * empty() -- 返回队列是否为空。
     */

    private static Stack<Object> stack1 = null;
    private static Stack<Object> stack2 = null;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int value = 0;
        while (!stack1.empty()) {
            stack2.push(stack1.peek());
            stack1.pop();
        }
        value = (int)stack2.pop();
        while (!stack2.empty()) {
            stack1.push(stack2.peek());
            stack2.pop();
        }
        return value;
    }

    /** Get the front element. */
    public int peek() {
        int value = 0;
        while (!stack1.empty()) {
            stack2.push(stack1.peek());
            stack1.pop();
        }
        value = (int)stack2.peek();
        while (!stack2.empty()) {
            stack1.push(stack2.peek());
            stack2.pop();
        }
        return value;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */