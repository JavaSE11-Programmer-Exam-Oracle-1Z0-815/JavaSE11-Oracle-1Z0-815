import java.io.IOException;

class StaticTest {
    public static String currentMessage;

    // Initialized to 0
    public static int currentVal;

    // Static Initializer
    static {
        System.out.println("Initializing class StaticTest");
        try {
            // We force an error for demonstration purposes
            if ((10 / currentVal) > 0) {
                System.out.println("Whoops");
            }
        }catch(Exception e){
            System.out.println("Caught the error");
        }
        finally {
            currentVal=1;
        }
        currentMessage = "Inside Static Initializer";
    }
}

class InitializerExceptions {

    // Constructor declares IOException in a throws clause
    InitializerExceptions() throws IOException {

    }

    // Create an instance initializer block that throws an unchecked exception
    {
        int i = 0;
        if (i == 0) throw new IOException("Whoops");
    }
    public static void main(String[] args) {


        System.out.println("Executing main()");
        System.out.println(StaticTest.currentMessage);

        try {
            InitializerExceptions ie = new InitializerExceptions();
        } catch (Exception e) {
            System.out.println("Ignoring the error, " + e.getMessage());
        }
    }
}
