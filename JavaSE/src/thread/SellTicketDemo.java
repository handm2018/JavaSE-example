package thread;

/**
 * 卖票案例
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/01/29 14:39
 */
public class SellTicketDemo {

    public static void main(String[] args) {
        SellTicket sellTicket = new SellTicket();
        Sell sellTicket1 = new Sell("1");
        Sell sellTicket2 = new Sell("2");
        Sell sellTicket3 = new Sell("3");

//        sellTicket1.start();
//        sellTicket2.start();
//        sellTicket3.start();


        Thread t1 = new Thread(sellTicket, "窗口1");
        Thread t2 = new Thread(sellTicket, "窗口2");
        Thread t3 = new Thread(sellTicket, "窗口3");


        t1.start();
        t2.start();
        t3.start();
    }


    static class Sell extends Thread{
        private static int ticket = 100;

        public Sell(String name) {
            super(name);
        }

        Object object = new Object();
        @Override
        public void run() {
            while (true) {
                synchronized (Sell.class) {
                    if (ticket > 0) {
                        System.out.println(Thread.currentThread().getName() + "窗口卖了一张票" + ticket);
                        ticket--;
                    }

                }
            }

        }
    }

}
