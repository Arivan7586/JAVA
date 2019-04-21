package www.arivan.Test4_21;

import java.util.Queue;

/**
 * 消费者
 */
public class Consumer implements Runnable {

    private final Queue<Goods> queue;

    private final Long speed;

    public Consumer(Queue<Goods> queue, Long speed) {
        this.queue = queue;
        this.speed = speed;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(this.speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this.queue) {
                if (this.queue.isEmpty()) {
                    System.out.println(Thread.currentThread()
                            .getName()+ "商品已空，通知生产");
                    this.queue.notifyAll();
                } else {
                    Goods goods = this.queue.poll();
                    if (goods != null) {
                        System.out.println(Thread.currentThread()
                        .getName()+"商品队列有货  消费商品"+goods);
                    }
                }
            }
        }
    }
}
