class Person{

    // String name = "阿怪";
    // public static void print(){
    //     System.out.println(Name);  静态方法不可以调用非静态属性
    // }

    // public void print(){  //非静态方法可以调用静态属性
    //     System.out.println(name); 
    // }

    private String name ;
    private int age;
    private String address;

    public Person(){
        System.out.println("谁长得最帅？");
    }

    public Person(String name){  //构造方法的重载
        this();
        System.out.println(name+"最帅");
    }

    public void print(){  //非静态方法可以调用静态属性
        System.out.println(name); 
    }

    //setter方法访问，修改private属性，getter方法获取private属性
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
            this.age = -1;
        }
    }
    public int getAge(){
        return this.age;
    }

    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return this.address;
    }
}

public class Test12_14{
    public static void main(String[] args){
        Person ag = new Person("小黑");
        //ag.print();
        ag.setName("阿怪");
        ag.setAge(22);
        ag.setAddress("西安");
        System.out.print(ag.getName());
        System.out.print(ag.getAge()+"岁，");
        System.out.print("在"+ag.getAddress()+"上大学");
    }
}