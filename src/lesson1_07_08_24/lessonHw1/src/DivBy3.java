public class DivBy3 extends Thread{
    @Override
    public void run() {
        int i =1;
        while (true){
            i++;
            if (i%3 == 0){
                System.out.println(i + " dividers by 3");

            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
