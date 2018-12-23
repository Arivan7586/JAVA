import java.util.Scanner;
abstract class CaffeineBeverage {
    void prepareBaverage(){  //冲饮料的算法
        boilWater();
        brew();
        pourInCup();
        if(customer()){
            addCondiments();
        }
    }

    void boilWater(){
        System.out.println("将水烧开");
    }
    void pourInCup(){
        System.out.println("倒进杯子里");
    }

    abstract void brew();
    abstract void addCondiments();

    boolean customer(){
        return true;
    }
}
class Coffee extends CaffeineBeverage{
    void brew(){
        System.out.println("用开水冲咖啡");
    }
    void addCondiments(){
        System.out.println("加糖和牛奶");
    }

    public boolean customer(){
        String answer = getUserInput();
        if(answer.equals("y")){
            return true;
        }else{
            return false;
        }
    }

    private String getUserInput(){
        String answer = null;
        System.out.println("您想要在咖啡中加入牛奶或糖吗 (y/n)?");
        Scanner scanner = new Scanner(System.in);
        answer = scanner.nextLine();
        return answer;
    }
}
class Tea extends CaffeineBeverage{
    void brew(){
        System.out.println("用开水泡茶叶");
    }
    void addCondiments(){
        System.out.println("加柠檬");
    }

    public boolean customer(){
        String answer = getUserInput();
        if(answer.equals("y")){
            return true;
        }else{
            return false;
        }
    }

    private String getUserInput(){
        String answer = null;
        System.out.println("您想要在茶中加入柠檬吗 (y/n)?");
        Scanner scanner = new Scanner(System.in); 
        answer = scanner.nextLine(); 
        return answer;
    }
}

public class Test12_23{
    public static void main(String[] args){
        Coffee coffee = new Coffee();
        coffee.prepareBaverage();
        System.out.println("************************");
        Tea tea = new Tea();
        tea.prepareBaverage();
    }
}

// class Coffee{
//     public void prepare(){
//         boilWater();
//         brewTea();
//         pourInCup();
//         addLemon();
//     }

//     public void boilWater(){
//         System.out.println("烧开水");
//     }
//     public void brewCoffee(){
//         System.out.println("用开水泡咖啡");
//     }
//     public void pourInCup(){
//         System.out.println("将咖啡倒进杯子里");
//     }
//     public void addSugarAndMilk(){
//         System.out.println("加糖和牛奶");
//     }
// }

// class Tea{
//     public void prepare(){
//         boilWater();
//         brewTea();
//         pourInCup();
//         addLemon();
//     }

//     public void boilWater(){
//         System.out.println("烧开水");
//     }
//     public void brewTea(){
//         System.out.println("用开水泡茶");
//     }
//     public void pourInCup(){
//         System.out.println("将茶倒进杯子里");
//     }
//     public void addLemon(){
//         System.out.println("加柠檬");
//     }
// }

// public class Test12_23{
//     public static void main(String[] args){
//         Coffee coffee = new Coffee();
//         coffee.prepare();
//         Tea tea = new Tea();
//         tea.prepare();
//     }
// }

// //抽象类
// abstract class Person{
//     public Person(){ //3
//         this.print(); //4
//     }

//     public abstract void print(); //4
// }
// class Student extends Person{
//     private int num = 100;  //在super（）方法结束后才会给num赋值。
//     public Student(int num){
//         super(); //2
//         this.num = num;
//     }

//     public void print(){  //5
//         System.out.println(this.num); //6  此时super（）方法结束。
//     }
// }

// public class Test12_23{
//     public static void main(String[] args) {
//      new Student(30);   //1
//     }
// }