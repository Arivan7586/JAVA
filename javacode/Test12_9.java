class Person{
    public void say(){
        System.out.println("我是父类！");
    }
}

class Work extends Person{
    public void say(){
        System.out.println("我是子类，是个工人！");
    }
    public void worker(){
        System.out.println("我是工人！");
    }
}

class Student extends Person{
    public void say(){
        System.out.println("我是子类，是个学生！");
    }
}

public class Test12_9{
    public static void main(String[] args){
        // Person per = new Work(); //发生向上转型（自动）
        // per.say();
        // Work w = (Work) per;    //发生向下转型（需要强转）
        // w.work();

        // Person p = new Work();
        // p.say();
        // Person pp = new Student();
        // pp.say();

        run(new Work());
        run(new Student());
    }

    public static void run(Person per){
        per.say();
    }
}

// public class Test12_9{
//     public static void main(String[] args){
//         // Person per = new Person();
//         // per.say();

//         // Student stu = new Student();
//         // stu.say();
//         // College_Student cst =  new College_Student();
//         // cst.setName("王大锤");
//         // System.out.println("我叫"+cst.getName());

//         double a = 1.0;
//         double b = 1.0;
//         float c = 1.0f;
//         c = a + c; //double型和float型 做+、-、*、/、%运算时，结果会自动转为double型
//         System.out.println(c);
//     }
// }

// class Person{
//     private String name;

//     public Person(){
//         System.out.println("我是小黑！");
//     }

//     public void setName(String name){
//         this.name = name;
//     }
//     public String getName(){
//         return this.name;
//     }
//     public void say(){
//         System.out.println("我是父类！");
//     }
// }

// class Student extends Person{
//     public Student(){
//         //super.Person();
//         System.out.println("小黑你好！");
//         System.out.println("我是学生！");
//     }
    
//     public void say(){
//         super.say();
//         System.out.println("我是子类！"); //方法的覆写
//     }
// }

// class College_Student extends Student{ //继承Person类 和 Student 类
//     public College_Student(){
//         System.out.println("我是大学生！"); 
//     }
// }