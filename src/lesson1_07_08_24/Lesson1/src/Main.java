public class Main {
    public static void main(String[] args) {

        Long start = System.currentTimeMillis();
        System.out.println("Main start");


        MyThread1 thread1 = new MyThread1(100,110);
        MyThread1 thread1a = new MyThread1(120,130);
        Thread thread2 = new Thread(new MyTask());

        Runnable clockTask = () -> {
            while (true) {
                System.out.println("Часы: " + System.currentTimeMillis());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread thread3 = new Thread(clockTask);
        thread3.setDaemon(true);


        thread1.start();
        thread1a.start();
        thread2.start();
        thread3.start();




        for (int i = 1; i < 10; i++) {

            System.out.println("Main: " + i);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        try {
            thread1.join();
            thread1a.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main finish");
        Long end = System.currentTimeMillis();
        System.out.println("Time:" + (end-start));


    }
}
