package www.arivan.Test4_15;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestThread {
    public static void main(String[] args) {
//        new ThreadA("Thread-A").start();
//        new ThreadA("Thread-B").start();
//        new ThreadA("Thread-C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        }).start();

//        FutureTask<String> futureTask = new FutureTask<>(new CallableTest());
//        new Thread(futureTask).start();
//        new Thread(futureTask).start();
//        try {
//            System.out.println(futureTask.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

//        RunnableA runnableA = new RunnableA();
//        new Thread(runnableA,"黄牛A").start();
//        new Thread(runnableA,"黄牛B").start();
//        new Thread(runnableA,"黄牛C").start();

//        RunnableB runnableB = new RunnableB();
//        new Thread(runnableB,"黄牛A").start();
//        new Thread(runnableB,"黄牛B").start();
//        new Thread(runnableB,"黄牛C").start();

        new Thread(new RunnableTest()).start();
    }
}

/**
 * Thread实现多线程
 */
class ThreadA extends Thread {
    private String title;

    public ThreadA(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.title + " " + i);
        }
    }
}

class RunnableTest implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+"="+i);
        }
    }
}

/**
 * Callable实现多线程
 */
class CallableTest implements Callable<String> {
    private Integer ticket = 10;

    @Override
    public String call() throws Exception {
        while (this.ticket > 0) {
            System.out.println("剩余票数："+(--this.ticket));
        }
        return "票卖完了！！！";
    }
}

/**
 * 线程锁，模拟买票
 */
class RunnableA implements Runnable {
    private int ticket = 30;

    @Override
    public void run() {
        while (this.ticket > 0) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if (this.ticket > 0) {
                    System.out.println(Thread.currentThread()
                            .getName()+"买票，剩余票数："+(--this.ticket));
                    if (this.ticket == 0) {
                        System.out.println("票卖完了！！！");
                    }
                }
            }
        }
    }
}

class RunnableB implements Runnable {
    private int ticket = 30;

    @Override
    public void run() {
        while (this.ticket > 0) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            buyTickets();
        }
    }

    private synchronized void buyTickets() {
        if (this.ticket > 0) {
            System.out.println(Thread.currentThread()
                    .getName()+"买票，剩余票数："+(--this.ticket));
            if (this.ticket == 0) {
                System.out.println("票卖完了！！！");
            }
        }
    }
}

