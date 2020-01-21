import java.io.IOException;

public class AFinalTry {
    public static void main(String[] args) {
        someMethodThrowsException();
    }

    public static void someMethodThrowsException() {
        try {
            System.out.println("Doing something");
        } catch (Exception e) {
            throw new IOException("Testing Catch");
        } finally {
            throw new RuntimeException("Testing finally");
        }
    }

    public static void testOfCheckedException(){
        // this wil NOT work:
     /*
        try{
            System.out.println("");
        } catch (IOException e) {
            e.printStackTrace();
        }
     */

        // THIS WORKS FINE
        try{
           throw new IOException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
