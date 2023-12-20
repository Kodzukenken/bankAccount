import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Update{
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            // Writing data to the file
            writer.write("Hello, this is a sample text.");
            writer.newLine();
            writer.write("Yay");

            System.out.println("Data has been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
