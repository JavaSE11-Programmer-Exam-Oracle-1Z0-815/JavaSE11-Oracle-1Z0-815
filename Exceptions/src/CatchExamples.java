import java.io.IOException;

class CustomException extends Exception {
    CustomException(String message) {
        super(message);
    }
}


class SuperClass {
    public void methodSuperClass() throws CustomException {

    }
}

class SubClass extends SuperClass {
    public void methodSubClass() {
        try {
            methodSuperClass();
        } catch (Exception CustomException) {
            // ignore it
        }
    }
}

public class CatchExamples {
    public static void main(String[] args) {
        CatchExamples ce = new CatchExamples();

        // Reminder, Throwable or custom subclasses of Throwable and any
        // RuntimeException descendants are checked.
        try {
            SubClass c = new SubClass();
            c.methodSuperClass();
            ce.testError();
        } catch (ArithmeticException e) {
            e = new ArithmeticException("This works");
            throw e;
        } catch (CustomException | RuntimeException | IOException e) {
            throw new RuntimeException("So many exceptions, so little time");
        }
    }

    private void testError() throws IOException {
        // We'll complete this later
    }
}
