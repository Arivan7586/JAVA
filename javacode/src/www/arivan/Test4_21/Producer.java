package www.arivan.Test4_21;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者
 */
public class Producer implements Runnable {
    private final Queue<Goods> queue;

    private final Long speed;

    private final Integer MaxGoods;

    private final AtomicInteger goodsId = new AtomicInteger(0);

    public Producer(Queue<Goods> queue, Long speed, Integer maxGoods) {
        this.queue = queue;
        this.speed = speed;
        this.MaxGoods = maxGoods;
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
                if (this.queue.size() >= this.MaxGoods) {
                    System.out.println(Thread.currentThread()
                            .getName() + "商品已满，停止生产");
                    try {
                        this.queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    Goods goods = new Goods("商品-"+
                            goodsId.getAndDecrement(),Math.random());
                    this.queue.add(goods);
                    System.out.println(Thread.currentThread().getName()
                    +"商品未满，生产商品"+goods);
                }
            }
        }
    }
}