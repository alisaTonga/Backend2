public class DivBy2 extends Thread{
    @Override
    public void run() {
        int i =1;
        while (true){
            i++;
            if (i%2 == 0){
                System.out.println(i + " dividers by 2");

            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
