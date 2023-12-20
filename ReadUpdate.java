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

        int opt, amt;
      String name, address;

      Scanner button = new Scanner(System.in);

      System.out.println("Please enter your name: ");
      name = button.nextLine();
      System.out.println("Please enter address: ");
      address = button.nextLine();
      System.out.println("Enter your initial balance: ");
      amt = button.nextInt();
      BankAccount acc = new BankAccount(amt, name, address); 
      

      do{  
         System.out.println("Menu");
         System.out.println("1. Create an account");
         System.out.println("2. Deposit");
         System.out.println("3. Withdraw");
         System.out.println("4. Display Bank Book Transaction");
         System.out.println("5. Exit");
         opt = button.nextInt();

      switch(opt){
         case 1:   
         //Creating an account
            System.out.println("Please enter your name: ");
            name = button.nextLine();
            System.out.println("Please enter address: ");
            address = button.nextLine();
            System.out.println("Enter your initial balance: ");
            amt = button.nextInt();
            BankAccount newAcc = new BankAccount(amt, name, address); 
      break;
         case 2:
         // Deposit
            System.out.println("Please enter amount to deposit: ");
            amt = button.nextInt();
            acc.deposit(amt);
      break;
         case 3:
         // Withdraw
            System.out.println("Please enter amount to withdraw: ");
            amt = button.nextInt();
            acc.withdraw(amt);
      break;
         case 4:
         //Printing transaction history
            acc.printTabungan();
      break;
         default:
         ;
      }
      }while (opt != 5 || opt >5 || opt < 1);


   }
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


