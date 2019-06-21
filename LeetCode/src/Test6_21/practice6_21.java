package Test6_21;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class practice6_21 {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> list1 = new LinkedList<>();
        list1.add(4);
        list1.add(5);
        list1.add(6);

        list.addAll(list1);
        System.out.println(list);
    }
}

//N叉树的后序遍历
class Solution {
    /**
     * 给定一个 N 叉树，返回其节点值的后序遍历。
     */
    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<Integer> postorder(Node root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        if (root.children.isEmpty()) {
            list.add(root.val);
            return list;
        }
        list = postorder(root.children.get(0));
        for (int i = 1; i < root.children.size(); i++) {
            list.addAll(postorder(root.children.get(i)));
        }
        list.add(root.val);
        return list;
    }
}

//N叉树的前序遍历
class Solution1 {
    /**
     * 给定一个 N 叉树，返回其节点值的前序遍历。
     */
    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            list.addAll(preorder(root.children.get(i)));
        }
        return list;
    }
}
