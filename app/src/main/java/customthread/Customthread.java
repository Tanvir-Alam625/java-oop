package customthread;

class thread1 extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread 1 is running:" + i);
        }
    }
}

class thread2 extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread 2 is running:" + i);
        }
    }
}

class thread3 extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread 3 is running:" + i);
        }
    }
}

public class Customthread {
    public static void main(String[] args) {
        thread1 t1 = new thread1();
        thread2 t2 = new thread2();
        thread3 t3 = new thread3();
        t1.start();
        t2.start();
        t3.start();
    }

}
