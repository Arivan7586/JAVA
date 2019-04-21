package www.arivan.Test4_21;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TestProducerConsumer {

    private static void code1() {
        final Queue<Goods> queue = new LinkedList<>();
        final Integer maxGoods = 10;

        final Producer producer = new Producer(queue,2500L,maxGoods);
        final Consumer consumer = new Consumer(queue,1000L);

        Thread producerThread1 = new Thread(producer,"生产者-1");
        Thread consumerThread1 = new Thread(consumer,"消费者-1");
        producerThread1.start();
        consumerThread1.start();

//        for (int i = 0; i < 5; i++) {
//            new Thread(producer,"Thread-producer-"+i).start();
//        }
//
//        for (int i = 0; i < 8; i++) {
//            new Thread(consumer,"Thread-consumer-"+i).start();
//        }
    }

    private static void code2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入容量大小：");
        final Integer maxGoods = scanner.nextInt();

        System.out.println("请输入生产者数量：");
        final Integer producers = scanner.nextInt();

        System.out.println("请输入生产者速率(ms)：");
        final Long producerSpeed = scanner.nextLong();

        System.out.println("请输入消费者数量：");
        final Integer consumers = scanner.nextInt();

        System.out.println("请输入消费者速率(ms)：");
        final Long consumerSpeed = scanner.nextLong();

        final Queue<Goods> queue = new LinkedList<>();
        final Producer producer = new Producer(queue,producerSpeed,maxGoods);
        final Consumer consumer = new Consumer(queue,consumerSpeed);

        for (int i = 0; i < producers; i++) {
            new Thread(producer,"Thread-producer-"+i).start();
        }

        for (int i = 0; i < consumers; i++) {
            new Thread(consumer,"Thread-consumer-"+i).start();
        }
    }

    public static void main(String[] args) {
        code2();
    }
}
