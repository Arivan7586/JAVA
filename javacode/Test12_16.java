class Person{
    private String name;
    private static String country = "韩国"; //共享属性

    public Person(){
        System.out.println("阿怪你好！");
    }

    public Person(String country){  //构造方法的重载
        this.country = country;
        System.out.println(this.country);
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void print(){
        System.out.println(this.name+"是"+this.country+"人");
    }
}

class Student extends Person{
    public Student(){
        super("China");   //super调用父类构造方法。必须在第一行
        System.out.println("阿怪最帅！");
    }
    // public Student(String name){
    //     this.name = name;   //子类不可以修改父类私有属性
    // }

    public void fun(){

        print();
    }
}

public class Test12_16{
    public static void main(String[] args){
        // Person p = new Person();
        // p.setName("阿怪");
        // p.print();

        // Person pp = new Person();
        // pp.setName("小黑");
        // pp.print();

        Student stu = new Student();
        stu.setName("小龙");
        stu.fun();
    }
}