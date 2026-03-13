package runablethread;
class thread1 implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread 1 is running:" + i);
        }
    }
}

class thread2 implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread 2 is running:" + i);
        }
    }
}

class thread3 implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread 3 is running:" + i);
        }
    }
}

public class Runablethread {
    public static void main(String[] args) {
        thread1 t1 = new thread1();
        thread2 t2 = new thread2();
        thread3 t3 = new thread3();
        t1.run();
        t2.run();
        t3.run();
        // Thread thread1 = new Thread(t1);
        // Thread thread2 = new Thread(t2);
        // Thread thread3 = new Thread(t3);
        // thread1.start();
        // thread2.start();
        // thread3.start();
    }
}
