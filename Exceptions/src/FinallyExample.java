import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FinallyExample {
    public static void main(String[] args) {
        FinallyExample fex = new FinallyExample();
        try {
            System.out.println("Outer try block starts here....");
            String property = fex.getPropertyFromFile("FinallyProperties.txt");
        } catch (IOException | ArrayIndexOutOfBoundsException io) {
            System.out.println("Outer catch exception block starts here....");
            try {
                // Retry;
                System.out.println("Inner try block attempts retry....");
                String line = fex.getPropertyFromFile("AnotherProperties.txt");

            } catch (IOException e) {
                System.out.println("Inner catch exception block starts here....");
            }
        }
    }

    private String getPropertyFromFile(String filename) throws IOException {

        String property;
        BufferedReader br =
                new BufferedReader(new FileReader(filename));
        try {
            String line = br.readLine();
            property = line.split("\\s")[2];
            System.out.println("Property value = " + property);
        } finally {

            if (br != null) br.close();
        }
        return property;
    }
}
