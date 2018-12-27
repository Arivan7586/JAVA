abstract class Role{
    private String name;
    private int age;
    private String sex;

    public abstract void play();

    public Role(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Role(String name, int age, String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

    public void setSex(String sex){
        this.sex = sex;
    }

    public String getSex(){
        return this.sex;
    }
}

class Employee extends Role{
    private double salary;
    private static String ID;

    public Employee(String name, int age, double salary){
        super(name, age);
        this.salary = salary;
    }

    public Employee(String name, int age, String sex, double salary){   //构造方法的重载
        super(name, age, sex);   //super调用父类构造方法。
        this.salary = salary;
    }

    public void play(){
        System.out.println(this.getName()+"现在"+this.getAge()+"岁了，正在游乐园玩耍");   //通过get方法访问父类私有域。
    }

    public final void sing(){
        System.out.println(this.getName()+"在寂寞的玩彩虹六号");
    }
}

class Manager extends Employee{
    public static final String vehicle = "Benz";  //静态成员变量
    public Manager(String name, int age, double salary){
        super(name,age,salary);
    }
}

public class Test12_27{
    public static void main(String[] args){
        Employee e = new Employee("小黑",20,10000.1);
        e.play();
        e.sing();

        Manager manager = new Manager("大聪明",18,8888888.8);
        manager.play();
        manager.sing();
        System.out.println(Manager.vehicle);  //静态成员变量直接通过类名访问
    }
}