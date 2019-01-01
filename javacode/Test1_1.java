// //StringBuffer类 
// public class Test1_1{
//     public static void main(String[] args){
//         StringBuffer s = new StringBuffer();
//         s.append("hello").append(" world");  //append方法可拼接两个字符串
//         System.out.println(s);
//         System.out.println(s.reverse());   //字符串反转

//         System.out.println(s.delete(6,11)); //字符串删除

//         System.out.println(s.delete(6,11).insert(6,"arivan")); //插入字符串
//     }
// }

class Person{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;

    }

    public String toString(){  //覆写toString方法，取得对象的信息
        return "姓名为："+this.name+"。年龄为："+this.age;
    }

    public boolean equals(Object obj){  //覆写equals方法
        if(obj == this){
            return true;
        }
        if(!(obj instanceof Person)){
            return false;
        }

        Person per = (Person) obj;
        return per.name.equals(this.name) && per.age == this.age;  //向下转型
    }
}

class Student{
    private String name;
    private int age;

    public Student(String name, int age){
        this.name = name;
        this.age = age;

    }
}

public class Test1_1{
    public static void main(String[] args){
        //fun(new Person());
        // fun(new Person("arivan",20));
        // fun(new Student("arivan",20));   //没有覆写toString类，输出地址
        // fun("hello");

        Person p1 = new Person("arivan",20);
        Person p2 = new Person("arivan",20);  
        System.out.println(p1.equals(p2)); //字符串的比较
    }

    public static void fun(Object obj){
        System.out.println(obj);
    }
}

object类可以接收数组对象
public class Test1_1{
    public static void main(String[] args){
        Object o = new int[]{1,2,3,4,5,6,7,8,9}; 
        int[] arr = (int[]) o;
        for(int i : arr){
            System.out.print(i+"、");
        }
    }
}

//Object接收接口对象
// interface Imessage{
//     void getMessage();
// }

// class MessageImpl implements Imessage{
//     public void getMessage(){
//         System.out.println("hello");
//     }
// }

// public class Test1_1{
//     public static void main(String[] args){
//         Imessage im = new MessageImpl(); //子类向父接口转型
//         Object obj = im;
//         System.out.println(obj);
//         Imessage i = (Imessage) obj;
//         i.getMessage();
//     }
// }

//字符串转换为基本数据类型
// public class Test1_1{
//     public static void main(String[] args){
//         String s = "123456";

//         String s1 = "abcde12355"; //转换之前应该判断字符串是否为纯数字。
//         int num = Integer.parseInt(s);  
//         System.out.println(num);
//         System.out.println(Integer.parseInt(s1)); //NumberFormatException
//     } 
// }