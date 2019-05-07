package Test5_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class practice5_7 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.push(1);
        solution.push(2);
        solution.push(3);
        System.out.println(solution.pop());
        System.out.println(solution.stack1);

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.minNumberInRotateArray(
                new int[]{3,4,5,1,2}));

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.JumpFloor(10));

        System.out.println("---------------------");
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.Add(0,1));

        Solution4 solution4 = new Solution4();
        int[] arr = solution4.multiply(new int[]{1,2,3,4});
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}

/**
 * 用两个栈实现队列
 */
class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack1.isEmpty()) {
            int value = stack1.pop();
            stack2.push(value);
        }
        stack2.push(node);
        while (!stack2.isEmpty()) {
            int value = stack2.pop();
            stack1.push(value);
        }
        stack2.clear();
    }

    public int pop() {
        return stack1.pop();
    }
}

class Solution1 {
    /**
     * 旋转数组的最小数字
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     * @param array 给定数组
     * @return 返回符合要求的数字
     */
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        Arrays.sort(array);
        return array[0];
    }
}

class Solution2 {
    /**
     * 跳台阶
     * @param target 给定台阶层数
     * @return 返回跳法的数目
     */
    public int JumpFloor(int target) {
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return JumpFloor(target-1) + JumpFloor(target-2);
        }
    }
}

class Solution3 {
    /**
     * 不用加减乘除做加法
     * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号
     * @param num1
     * @param num2
     * @return 返回两数之和
     */
    public int Add(int num1,int num2) {
        int sum = 0;
        while (true) {
            sum = num1 ^ num2;
            int flag = (num1 & num2) << 1;
            if (flag == 0) {
                break;
            }
            num1 = sum;
            num2 = flag;
        }
        return sum;
    }
}

class Solution4 {
    /**
     * 构建乘积数组
     * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
     * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
     * @param A 给定数组
     * @return 返回乘积数组
     */
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return new int[]{};
        }
        int[] arr = new int[A.length];
        for (int i = 0; i < arr.length; i++) {
            int sum = 1;
            for (int j = 0; j < A.length; j++) {
                if (j != i) {
                    sum *= A[j];
                }
            }
            arr[i] = sum;
        }
        return arr;
    }
}