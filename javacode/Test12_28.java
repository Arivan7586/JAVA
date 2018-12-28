import java.util.Scanner;

//简单工厂模式
interface Computers{
    void printComputer();
}

class MacBook implements Computers{
    public void printComputer(){
        System.out.println("I want to buy a MacBook");
    }
}

class SurfaceBook implements Computers{
    public void printComputer(){
        System.out.println("I want to buy a surfaceBook");
    }
}

class ComputerFactory {
    public static Computers getInstance(String type){
        Computers computer = null;
        if(type.equals("MacBook")){
            computer = new MacBook();
        }else if(type.equals("SurfaceBook")){
            computer = new SurfaceBook();
        }
        return computer;
    } 
}

public class Test12_28{
    public void buyComputer(Computers computer){
        computer.printComputer();
    }
    public static void main(String[] args){
        Test12_28 t = new Test12_28();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要买的电脑型号");
        String type = scanner.nextLine();
        Computers computer = ComputerFactory.getInstance(type);
        t.buyComputer(computer);
    
        // Computer computer = new Computer();
        // computer.plugin(new UDisk());
        // computer.plugin(new Key_Board());
    }
}

interface Usb {   //接口以interface开头
    public void setup();  //安装驱动程序
    public void work();    // 开始运行
} 
class Computer {
    public void plugin(Usb usb){
        usb.setup();
        usb.work();
    }
}

class UDisk implements Usb { //定义一个设备
    public void setup(){
        System.out.println("安装U盘驱动");
    }
    public void work(){
        System.out.println("U盘开始工作");
    }
}

class Key_Board implements Usb{
    public void setup(){
        System.out.println("安装键盘驱动");
    }
    public void work(){
        System.out.println("键盘开始工作");
    }
}