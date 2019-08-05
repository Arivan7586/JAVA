package Test8_5;

import java.util.LinkedHashMap;

public class practice8_5 {

    public static void main(String[] args) {

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.VerifySquenceOfBST(new int[]{1,2,3,4,5}));

    }
}

//字符流中第一个不重复的字符
class Solution {
    private LinkedHashMap<Character,Integer> map = new
            LinkedHashMap<>();
    StringBuffer s=new StringBuffer();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        s.append(ch);
        if (map.isEmpty() || !map.containsKey(ch)) {
            map.put(ch,1);
        } else {
            int value = map.get(ch);
            map.put(ch,value + 1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for (char c : map.keySet()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return '#';
    }
}


//二叉搜索树的后溪遍历序列
class Solution1 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < sequence.length-1; i++) {
            if (sequence[i] < sequence[i+1]) {
                count++;
            }
        }
        if (count == sequence.length - 1 || count == 0) {
            return true;
        }
        return judge(sequence,0,sequence.length-1);
    }
    private boolean judge(int[] arr, int start, int end) {
        if (end == start) {
            return true;
        }
        if (end - start == 1) {
            return arr[start] < arr[end];
        }
        if (arr[start] > arr[end]) {
            return false;
        }
        if (end - start == 2) {
            if (arr[start] < arr[end] && arr[end] < arr[start+1]) {
                return true;
            }
            return false;
        }
        //找到比arr[end]小的最后一个元素的下标
        int index = start;
        for (int i = start; i <= end ; i++) {
            if (arr[i] < arr[end]) {
                index = i;
            } else {
                break;
            }
        }
        for (int i = index + 1; i < end; i++) {
            if (arr[i] < arr[end]) {
                return false;
            }
        }
        return judge(arr,start,index) && judge(arr,index+1,end-1);
    }
}

//对称的二叉树
class Solution2 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null) {
            return true;
        }
        return judge(pRoot.left,pRoot.right);
    }

    private boolean judge(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 != node2 && (node1 == null || node2 == null)) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return judge(node1.left,node2.right) && judge(node1.right,node2.left);
    }
}