package Test4_29;

import java.util.*;

public class practice4_29 {
    public static void main(String[] args) {
        String[] arr1 = new String[]{"bella", "label", "roller"};
        String[] arr2 = new String[]{"cool", "lock", "cook"};
        Solution solution = new Solution();
        System.out.println(solution.commonChars(arr1));
        System.out.println(solution.commonChars(arr2));

        Solution1 solution1 = new Solution1();
        int[] arr = solution1.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        int[] arr3 = solution1.intersect(new int[]{1, 2}, new int[]{1, 1});
        for (int i : arr3) {
            System.out.println(i);
        }

        System.out.println("---------------------");
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.top());
    }
}

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符
 * （包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，
 * 但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * 你可以按任意顺序返回答案。
 */
class Solution {
    /**
     * 查找常用字符
     *
     * @param A 给定仅有小写字母组成的字符串数字
     * @return 返回每个字符串中都显示的全部字符
     */
    public List<String> commonChars(String[] A) {
        List<String> list = new LinkedList<>();
        if (A == null) {
            return list;
        }
        Arrays.sort(A);
        for (int i = 0; i < A[0].length(); i++) {
            boolean flag = true;
            String value = String.valueOf(A[0].charAt(i));
            for (int j = 1; j < A.length; j++) {
                if (A[j].contains(value)) {
                    A[j] = A[j].replaceFirst(value, "");
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(value);
            }
        }
        return list;
    }
}

class Solution1 {
    /**
     * 两个数组的交集Ⅱ
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 返回交集数组
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        int[] arr1 = nums1.length < nums2.length ? nums1 : nums2;
        int[] arr2 = nums1.length >= nums2.length ? nums1 : nums2;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        LinkedList<Integer> list = new LinkedList<>();
        int flag = 0;
        for (int i = 0; i < arr1.length; i++) {
            int value = arr1[i];
            for (int j = flag; j < arr2.length; j++) {
                if (arr2[j] == value) {
                    list.add(arr2[j]);
                    flag = j + 1;
                    break;
                }
            }
        }
        int[] res = new int[list.size()];
        Iterator<Integer> iterator = list.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            res[i++] = iterator.next();
        }
        return res;
    }
}

/**
 * 用队列实现栈
 */
class MyStack {
    private  Queue<Object> stack;
    private  Queue<Object> queue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        stack = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue = new LinkedList<>();
        queue.add(x);
        while (!stack.isEmpty()) {
            queue.add(stack.poll());
        }
        stack = queue;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return (int) stack.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return (int) stack.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */