package Test7_9;

import jdk.nashorn.api.tree.Tree;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class practice7_9 {

    public static void main(String[] args) {

//        Person Jack = new Person("Jack",20);
//        Person Tom = new Person("Tom",25);
//        Person Alice = new Person("Alice",18);
//
//        System.out.println(Jack);
//
//        TreeSet<Person> set = new TreeSet<>();
//        set.add(Jack);
//        set.add(Tom);
//        set.add(Alice);
//
//        System.out.println(set);

//        Solution.solution();


       // E:\V1R2\product\fpgadrive.c 1325


        Solution2.solution();
    }
}

//说反话
class Solution {
    /**
     * 给定一句英语，要求编写代码，将句中所有的单词的顺序颠倒输出
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.nextLine();
            String[] arr = input.trim().split(" ");
            for (int i = arr.length-1; i >= 0; i--) {
                System.out.print(arr[i]);
                if (i != 0) {
                    System.out.print(" ");
                }
            }
        }
        in.close();
    }
}

//简单错误记录
class Solution2 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        while (in.hasNext()) {
            String input = in.next();
            int num = in.nextInt();
            String[] arr = input.split("\\\\");
            String key = arr[arr.length-1];
            if (key.length() > 16) {
                key = key.substring(key.length()-16);
            }
            key += " " + num;
            if (map.containsKey(key)) {
                map.put(key,map.get(key)+1);
            } else {
                map.put(key,1);
            }
        }
        int i = 0;
        Set<String> set = map.keySet();
        int n = set.size();
        for (String str : set) {
            i++;
            if (i > n-8) {
                System.out.println(str+ " " + map.get(str));
            }
        }
    }
}


class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        if (o == null) {
            return 0;
        }
        if (this.age > o.age) {
            return 1;
        } else if (this.age < o.age) {
            return -1;
        } else {
            return 0;
        }
    }
}