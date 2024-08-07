public class Main {
    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        ThreadDiv2 first = new ThreadDiv2(1,15,2);
        ThreadDiv2 second = new ThreadDiv2(100, 120, 3);
        second.setDaemon(true);
        first.start();
        second.start();

        try {
            first.join();
            second.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Long end = System.currentTimeMillis();
        System.out.println("Time:" + (end-start));
    }
}