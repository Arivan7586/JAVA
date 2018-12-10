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

}

class Worker extends Person{
    public Worker(){
        System.out.println("我是子类");
    }
}

public class Test12_10{
    public static void main(String[] args){
        Person per = new Person();
        Worker w = new Worker();
        w.setName("小黑");
        w.setAge(25);
        System.out.println(w.getName());
        System.out.println(w.getAge());

        System.out.println(w.country);      
    }
}