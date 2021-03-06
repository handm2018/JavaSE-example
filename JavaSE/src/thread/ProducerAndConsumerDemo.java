package thread;

/**
 * 生产者和消费者模型
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/02/03 15:04
 */
public class ProducerAndConsumerDemo {

    public static void main(String[] args) {
        CubbyHole cubbyHole = new CubbyHole();

        Producer producer = new Producer(cubbyHole);
        Consumer consumer = new Consumer(cubbyHole);

        new Thread(producer).start();
        new Thread(consumer).start();
    }

}

class Producer implements Runnable {
    private CubbyHole cubbyHole;

    public Producer() {
    }

    public Producer(CubbyHole cubbyHole) {
        this.cubbyHole = cubbyHole;
    }

    @Override
    public void run() {
        for (int i = 1; i < 31; i++) {
            try {
                cubbyHole.put(i);
                System.out.println("生产第" + i + "个产品");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private CubbyHole cubbyHole;

    public Consumer() {
    }

    public Consumer(CubbyHole cubbyHole) {
        this.cubbyHole = cubbyHole;
    }

    @Override
    public void run() {
        while (true) {
            int i = 0;
            try {
                i = cubbyHole.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("消费第" + i + "个产品");
        }
    }
}


class CubbyHole {
    private int contents;
    private boolean available = false;

    public synchronized void put(int value) throws InterruptedException {
        if (available) {
            wait();
        }
        this.contents = value;
        available = true;
        notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        if (!available) {
            wait();
        }
        available = false;
        notifyAll();
        return contents;
    }

}