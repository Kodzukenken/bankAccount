import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class ReadUpdate {

    public static void main(String[] args) {
        String filePath = "example.txt";
        SimpleDateFormat timeStamp = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

        // Read the content from the file
        String fileContent = readFromFile(filePath);
        System.out.println("Current content of the file:");
        System.out.println(fileContent);

        // Modify the content (update as needed)
        String updatedContent = fileContent + timeStamp;

        // Write the updated content back to the file
        updateFile(filePath, updatedContent);
        System.out.println("File has been updated successfully.");

}


    private static String readFromFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    private static void updateFile(String filePath, String updatedContent) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(updatedContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

