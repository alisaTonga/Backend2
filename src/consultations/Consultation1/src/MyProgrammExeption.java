public class MyProgrammExeption extends RuntimeException{
    String msg;
    int value1;
    int value2;

    public MyProgrammExeption(String msg, int value1, int value2) {
        this.msg = msg;
        this.value1 = value1;
        this.value2 = value2;
    }
}
