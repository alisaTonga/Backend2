public class Main {
    public static void main(String[] args) {
        System.out.println(div(10,3));
        System.out.println(div(10,0));
    }
    public static int div(int a, int b){
        int res;
        try {
            res = a/b;
            return res;

        }
        catch (ArithmeticException e){
            throw new MyProgrammExeption("divide", a, b);
        }
        catch (Exception e ){
            System.out.println("error!");

        }
        return 0;
    }
}