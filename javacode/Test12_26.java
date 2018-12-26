class Person{
    private String name;
    private int age;
    static String country = "中国";

    public Person(){
        System.out.println("我是父类");
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setAge(int age){
        if(age >= 0 && age < 150){
            this.age = age;
        }else{
            this.age = 0;
        }
    }
    public int getAge(){
        return this.age;
    }
    public static void say(){
        System.out.println("我是一个人！");
    }
}

class Worker extends Person{
    public Worker(){
        System.out.println("我是子类");
    }
    public static void print(){
        System.out.println("我是一名工人！");
    }
}

class Student extends Worker{  //继承了Person类和Student类
    public static void say(){  
        System.out.println("我现在是一名学生！");  //方法的覆写
    }
}

public class Test12_26{
    public static void main(String[] args){
        // Person per = new Person();
        // Worker w = new Worker();
        // w.setName("小黑");
        // w.setAge(25);
        // System.out.println(w.getName());
        // System.out.println(w.getAge());

        // System.out.println(w.country);      

        Student stu = new Student();
        stu.say();
    }
}

//     //复习代码块和继承
// class Test{
//     {
//         System.out.println("1、父类构造块！");
//     }
//     public Test(){
//         System.out.println("2、父类构造方法代码块！");
//     }
//     static{
//         System.out.println("3、父类静态代码块！");
//     }
// }

// public class Test12_26 extends Test{
//     {
//         System.out.println("4、子类构造块！");
//     }
//     public Test12_26(){
//         System.out.println("5、子类构造方法代码块！");
//     }
//     static{
//         System.out.println("6、子类静态代码块！");
//     }
//     public static void main(String[] args){
//         System.out.println("7、main方法开始！");
//         new Test12_11();
//         new Test12_11();
//         System.out.println("8、main方法结束!");
//         //运行结果：3、6、7、1、2、4、5、1、2、4、5、8
//     }
// }