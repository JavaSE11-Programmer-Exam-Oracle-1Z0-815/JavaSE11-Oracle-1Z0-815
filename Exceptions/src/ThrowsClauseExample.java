public class ThrowsClauseExample {
    // Custom RuntimeException
    class ACustomRuntimeException extends RuntimeException {
        ACustomRuntimeException(String message) {
            super(message);
        }
    }

    // Custom Exception (not RuntimeException)
    class ACustomCheckedException extends Exception {
        ACustomCheckedException(String message) {
            super(message);
        }
    }

    // Custom Throwable
    class ACustomThrowable extends Throwable {
        ACustomThrowable(String message) {
            super(message);
        }
    }

    // Custom Error
    class AnError extends Error {
        AnError(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {

        ThrowsClauseExample t = new ThrowsClauseExample();

        // For loop allows us to test each exception thrown
        for (int i = 0; i < 4; i++) {
            try {
                switch (i) {
                    case 0:
                        t.methodOne();
                        break;
                    case 1:
                        t.methodTwo();
                        break;
                    case 2:
                        t.methodThree();
                        break;
                    case 3:
                        t.methodFour();
                        break;
                }
                // Catch clause is inside for loop, so execution of
                // for loop continues after we catch the exception
            } catch (Throwable e) {

                System.out.println("In the catch clause of main(): " +
                        e);
            }
        }
    }

    // Unchecked Runtime Exception Thrown
    private void methodOne() {
        throw new ACustomRuntimeException("Error in methodOne");
    }

    // Checked - must satisfy catch or specify - here we catch.
    private void methodTwo() {
        try {
            throw new ACustomCheckedException("Error in methodTwo");
        } catch (Exception e) {
            System.out.println("In the catch clause of methodTwo(): " +
                    e);
        }
    }

    // Checked - must satisfy catch or specify - here we specify
    // in the throws clause
    private void methodThree() throws ACustomThrowable {
        throw new ACustomThrowable("Error in methodThree");
    }

    // Unchecked Error thrown
    private void methodFour() {
        throw new AnError("Error in methodFour");
    }
}
