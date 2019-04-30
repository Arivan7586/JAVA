package Test4_30;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class practice4_30 {
    public static void main(String[] args) {
//        Runnable a = new A();
//        new Thread(a,"黄牛A").start();
//        new Thread(a,"黄牛B").start();
//        new Thread(a,"黄牛C").start();

//        Test test = new Test();
//        new Thread(test).start();
//        new Thread(test).start();
//        new Thread(test).start();

//        Solution solution = new Solution();
//        int[] arr = solution.numberOfLines(new int[]
//                {4,10,10,10,10,10,10,10,10,10,10,10,
//                        10,10,10,10,10,10,10,10,10,10,10,10,10,10},
//                "bbbcccdddaaa");
//        int[] arr1 = solution.numberOfLines(new int[]
//                        {10,10,10,10,10,10,10,10,10,10,10,10,
//                                10,10,10,10,10,10,10,10,10,10,10,10,10,10},
//                "abcdefghijklmnopqrstuvwxyz");
//        for (int i : arr1) {
//            System.out.println(i);
//        }

        Solution1 solution1 = new Solution1();
        System.out.println("-------------------");
        System.out.println(solution1.subdomainVisits(new String[]
                {"9001 discuss.leetcode.com"}));
        System.out.println(solution1.subdomainVisits(new String[]
                {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }
}


class Solution {
    /**
     * 写字符串需要的行数
     * @param widths 存放有每个字符所占的单位数的数组
     * @param S 需要写的字符串
     * @return 返回行数和最后一行所占单位数
     */
    public int[] numberOfLines(int[] widths, String S) {
        if (S == null || S.equals("")) {
            return new int[]{0,0};
        }
        int sum = 0;
        int count = 1;
        int num = 100;
        for (int i = 0; i < S.length(); i++) {
            int length = widths[S.charAt(i)-97];
            if (num >= length) {
                num -= length;
                sum += length;
            }else {
                i--;
                count++;
                num = 100;
                sum = 0;
            }
        }
        return new int[]{count,sum};
    }
}

class Solution1 {
    /**
     * 子域名访问计数
     * @param cpdomains 给定域名数组
     * @return
     */
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new LinkedList<>();
        if (cpdomains == null || cpdomains.length == 0) {
            return list;
        }
        //将所有域名和出现次数存入HashMap中，域名作为key，访问次数作为value
        HashMap<String,String> map = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String[] arr = split(cpdomains[i]);
            for (int j = 0; j < arr.length; j++) {
                String[] value = arr[j].split(" ");
                if (map.get(value[1]) == null) {
                    map.put(value[1],value[0]);
                } else {
                    int sum = Integer.parseInt(value[0])+
                            Integer.parseInt(map.get(value[1]));
                    map.put(value[1],String.valueOf(sum));
                }
            }
        }
        //将所有域名和访问次数用空格连接起来，存入Lisi中。
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = map.get(key) + " " + key;
            list.add(value);
        }
        return list;
    }

    /**
     * 求出给定网站域名的所有子域名以及访问次数
     * @param str 给定网站域名
     * @return 返回所有子域名组成的数组
     */
    private String[] split(String str) {
        String[] arr1 = str.split(" ");
        String[] arr2 = arr1[1].split("\\.");
        String[] res = new String[arr2.length];
        for (int i = 0; i < res.length; i++) {
            StringBuilder num = new StringBuilder(arr1[0]);
            num.append(" ");
            for (int j = i; j < arr2.length; j++) {
                res[i] = String.valueOf(num.append(arr2[j]));
                if (j != arr2.length-1) {
                    res[i] = String.valueOf(num.append("."));
                }
            }
        }
        return res;
    }
}

class A implements Runnable {
    private int tickets = 30;
    @Override
    public void run() {
        while (this.tickets > 0) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if (this.tickets > 0) {
                    System.out.println(Thread.currentThread().getName()+
                            "买票，剩余票数："+(--this.tickets));
                    if (this.tickets <= 0) {
                        System.out.println("票卖完了");
                        break;
                    }
                }
            }
        }
    }
}

class Test implements Runnable {
    private int n = 30;
    @Override
    public void run() {
        while (this.n > 0) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if (this.n > 0) {
                    System.out.println(Thread.currentThread().getName());
                }
            }
            n--;
        }
        System.out.println();
    }
}
