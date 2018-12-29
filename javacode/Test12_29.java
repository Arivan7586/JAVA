//  代理设计模式  //代购一台 SurfaceBook 电脑
// interface IBuy{
//     void buyComputer();   //核心功能是购买电脑
// }

// class RealBuy implements IBuy{
//     public void buyComputer(){
//         System.out.println("买一台SurfaceBook");
//     }
// }

// class ProxyBuy implements IBuy{  //代理操作
//     private IBuy buyer;

//     public ProxyBuy(IBuy buyer){
//         this.buyer = buyer;
//     }
    
//     public void beforeBuy(){
//         System.out.println("先去排队");
//     }
//     public void buyComputer(){
//         this.beforeBuy();
//         this.buyer.buyComputer();
//         this.afterBuy();
//     }
//     public void afterBuy(){
//         System.out.println("寄给买家");
//     }
// }

// 工厂方法模式
interface Computer{    //抽象产品类
    void printComputer(); 
}

class SurfaceBook implements Computer{   //具体产品类 
    public void printComputer(){
        System.out.println("this is a SurfaceBook!");
    }
}

class MacBook implements Computer{   //具体产品类 
    public void printComputer(){
        System.out.println("this is a MacBook!");
    }
}

interface ComputerFactory{    //抽象工厂 
    Computer creatComputer();
}

class MicrosoftFactory implements ComputerFactory{   //具体工厂
    public Computer creatComputer(){
        return new SurfaceBook();
    }
}

class AppleFactory implements ComputerFactory{  //具体工厂
    public Computer creatComputer(){
        return new MacBook();
    }
}

public class Test12_29{
    public void buyComputer(Computer computer){
        computer.printComputer();
    }

    public static void main(String[] args){
        Test12_29 t = new Test12_29();
        ComputerFactory m = new MicrosoftFactory();
        ComputerFactory a = new AppleFactory();
        t.buyComputer(m.creatComputer());
        t.buyComputer(a.creatComputer());
    }
}