package thread;

/**
 * TODO
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/01/26 10:42
 */
public class ThreadCreateDemo {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.setName("小猫");
        thread2.setName("小狗");
        thread1.start();
        thread2.start();
    }
}


class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ": " + i);
        }
    }
}
