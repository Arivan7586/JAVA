package Test6_29;

import java.util.ArrayList;
import java.util.List;

public class practice6_29 {

    public static void main(String[] args) {

        Employee employee1 = new Employee();
        employee1.id = 1;
        employee1.importance = 5;
        employee1.subordinates = new ArrayList<Integer>();
        employee1.subordinates.add(2);
        employee1.subordinates.add(3);

        Employee employee2 = new Employee();
        employee2.id = 2;
        employee2.importance = 3;

        Employee employee3 = new Employee();
        employee3.id = 3;
        employee3.importance = 3;

        List<Employee> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);

        Solution solution = new Solution();
        System.out.println(solution.getImportance(list,1));
    }
}

//员工的重要性

/**
 * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
 * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。
 * 那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数
 * 据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，
 * 因此没有体现在员工1的数据结构中。
 * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
 */
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null) {
            return 0;
        }
        int sum = 0;
        List<Integer> list = null;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).id == id) {
                sum += employees.get(i).importance;
                list = employees.get(i).subordinates;
                break;
            }
        }
        for (int k = 0; k < list.size(); k++) {
            sum += getImportance(employees,list.get(k));
        }
        return sum;
    }
}


//二叉搜索树节点最小距离
class Solution1 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
     * @param root 给定二叉搜索树的根节点
     * @return 返回任意两个节点差的最小值
     */
    public int minDiffInBST(TreeNode root) {
        if (root.left == null && root.right == null) {
            return Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            int value = Math.abs(root.val - maxOfBST(root.left));
            min = min < value ? min : value;
            int value2 = minDiffInBST(root.left);
            min = min < value2 ? min : value2;
        }
        if (root.right != null) {
            int value = Math.abs(root.val - minOfBST(root.right));
            min = min < value ? min : value;
            int value2 = minDiffInBST(root.right);
            min = min < value2 ? min : value2;
        }
        return min;
    }
    private int maxOfBST(TreeNode node) {
        return node.right == null ? node.val : maxOfBST(node.right);
    }
    private int minOfBST(TreeNode node) {
        return node.left == null ? node.val : minOfBST(node.left);
    }
}