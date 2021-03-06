package thread;

/**
 * 卖票案例 窗口
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/01/29 14:36
 */
public class SellTicket implements Runnable {

    private int ticket = 100;

    Object object = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (object) {
                if (ticket > 0) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName() + "窗口卖了一张票" + ticket);
                    ticket--;
                }

            }
        }

    }
}
