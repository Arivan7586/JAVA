package www.arivan.Test4_15;

public class TestSleep extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
//        new TestSleep().start();
//        new TestSleep().start();
//        new TestSleep().start();

        Runnable1 runnable = new Runnable1();
        new Thread(runnable, "黄牛A").start();
        new Thread(runnable, "黄牛B").start();
        new Thread(runnable, "黄牛C").start();
    }
}

class Runnable1 implements Runnable {
    private Integer tickets = 30;

    @Override
    public void run() {
        while (this.tickets > 0) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if (this.tickets > 0) {
                    System.out.println(Thread.currentThread().getName()
                            +"买票，剩余票数："+(--this.tickets));
                    if (this.tickets == 0) {
                        System.out.println("票卖完了！！！");
                    }
                }
            }
        }
    }
}