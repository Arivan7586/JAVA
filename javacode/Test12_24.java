import java.util.Scanner;

abstract class Make_beverage{   //抽象类
    public final void prepareBeverage(){   //用final限定，不可修改
        boilWater();
        brew();
        pourIntoCup();
        if(customer()){
            addCondiments();
        }      
    }

    public void boilWater(){
        System.out.println("烧开水！");
    }
    public void pourIntoCup(){
        System.out.println("倒进杯子里!");
    }

    abstract void brew();   //抽象方法
    abstract void addCondiments();

    boolean customer(){   //钩子方法
        return true;
    }
}

class Coffee extends Make_beverage {
    // public void prepareBeverage(){
    //     boilWater();
    //     brewCoffee();
    //     pourIntoCup();
    //     addCondiments();
    // }

    // public void boilWater(){
    //     System.out.println("烧开水！");
    // }
    // public void brewCoffee(){
    //     System.out.println("用开水冲咖啡！");
    // }
    public void brew(){
        System.out.println("用开水冲咖啡！");
    }
    // public void pourIntoCup(){
    //     System.out.println("倒进杯子里!");
    // }
    public void addCondiments(){
        System.out.println("加牛奶或者糖");
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
        System.out.println("您想要在咖啡中加入牛奶或糖吗（y/n）？");
        Scanner scanner = new Scanner(System.in);
        answer = scanner.nextLine();
        return answer;
    }
}

class Tea extends Make_beverage {
    // public void prepareBeverage(){
    //     boilWater();
    //     brewTea();
    //     pourIntoCup();
    //     addCondiments();
    // }

    // public void boilWater(){
    //     System.out.println("烧开水！");
    // }
    // public void brewTea(){
    //     System.out.println("用开水泡茶！");
    // }
    public void brew(){
        System.out.println("用开水泡茶！");
    }
    // public void pourIntoCup(){
    //     System.out.println("倒进杯子里！");
    // }
    public void addCondiments(){
        System.out.println("加柠檬！");
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
        System.out.println("请问您想在茶里面加柠檬吗？（y/n）?");
        Scanner scanner = new Scanner(System.in);
        answer = scanner.nextLine();
        return answer;
    }   
}

public class Test12_24{
    public static void main(String[] args){
        Coffee coffee = new Coffee();
        coffee.prepareBeverage();
        System.out.println("--------------------------------------");
        Tea tea = new Tea();
        tea.prepareBeverage();
    }
}