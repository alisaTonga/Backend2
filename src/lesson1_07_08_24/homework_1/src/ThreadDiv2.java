public class ThreadDiv2 extends Thread{
    private int start;
    private int end;
    private  int divider;

    public ThreadDiv2(int start, int end, int divider) {
        this.start = start;
        this.end = end;
        this.divider = divider;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getDivider() {
        return divider;
    }

    public void setDivider(int divider) {
        this.divider = divider;
    }

    @Override
    public String toString() {
        return "ThreadDiv2{" +
                "start=" + start +
                ", end=" + end +
                ", divider=" + divider +
                "} " + super.toString();
    }

    @Override
    public void run() {
        System.out.println("Thread is running..." + Thread.currentThread().getName());
        for (int i = start; i < end; i++) {
            if (i%divider == 0){
                System.out.println(i);
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread" + Thread.currentThread().getName() + " finished running");

    }
}
