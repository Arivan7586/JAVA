package www.arivan.Test1_7;

//
//1.编写一个算法来判断一个数是不是“快乐数”。
//        一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
//        然后重复这个过程直 到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，
//        那么这个数就是快乐数。
//        示例:
//        输入: 19 输出: true 解释:
//        1^2 + 9^2 = 82
//        8^2 + 2^2 = 68
//        6^2 + 8^2 = 100
public class Test1_7 {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.isHappy(19));
        System.out.println(solution.isHappy(20));
        System.out.println(solution.isHappy(21));
    }
}

class Solution {  //判断是不是快乐数
    public boolean isHappy(int n){
        int temp = n;
        while(true){
            temp = getNext(temp);
            if(temp == 1){
                return true;
            }else if (temp == 89){
                return false;
            }
        }
    }

    public static int getNext(int n){ //返回下一个数字
        int m = 0;
        while(n > 0){
            m = (n % 10)*(n % 10) + m;
            n = n / 10;
        }
        return m;
    }
}
