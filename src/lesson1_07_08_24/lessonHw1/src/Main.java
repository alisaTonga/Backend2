public class Main {
    public static void main(String[] args) {
        System.out.println("Main start");
        DivBy2 thread1 = new DivBy2();
        Thread thread2 = new Thread(new DivBy3());
        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main end");
    }
}