public class Test12_4{
    public static void main(String[] args){
        Person pp = new Person();
        Person p = new Person("小呆呆",60);   //构造方法的重载 
        //p.setName("小呆呆");
       // p.setAge(50);
        //p.run();
    }
}

class Person{
    private String name;  //类内部属性需要用private进行封装
    private int age;
    private String address;

    public  Person(){   //无参的构造方法
        System.out.println("*****************************");
    }
    public  Person(String n, int j){ 
        name = n;
        setAge(j);
        run();
    }
/*
    public void setName(String m){   //使用setter方法，对内部类进行操作
        name = m;
    }*/
    public String getName(){   //使用getter方法，获取内部类的属性
        return name;
    }

    public void setAge(int i){   
        if(i >= 0 && i <= 200){
            age = i;
        }else{
            System.out.println("年龄不正确！");
            //age = 0;
        }
    }
    public int getAge(){  
        return age;
    }

    public void run(){
        System.out.println(name+"今年"+age+"岁了");
    }
}