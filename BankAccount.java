import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class BankAccount
{  
   private String name;
   private double balance;
   private String address;
   private ArrayList<BankTransaction> BTlist = new  ArrayList<BankTransaction>() ;
   public BankAccount()
   {   
      balance = 0;
   } 

   public BankAccount(double initialBalance, String name, String address)
   {  this.name = name;
      this.address = address;
      this.balance = initialBalance;
      // newTransaction("Create Acc", initialBalance);
   }

   public void deposit(double amount, String info){
      balance = balance + amount;
      // BTlist.add(new BankTransaction("deposit", amount, balance));
      newTransaction(amount, "Deposit", info);
   } 

   public void withdraw(double amount, String info)
   { if (amount >= balance) {
      System.out.println("You don't have enough balance");
   } else {
      balance = balance - amount;
      newTransaction(amount, "Withdraw", info);
      }
   }

   public void transfer(double amount, BankAccount account){
      if(amount <= this.balance){
         this.balance = balance - amount;
      } else{
         System.out.println("You don't have enough balance");
      }
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public double getBalance(){   
      return balance;
   }

   private void newTransaction(double amount, String type, String info){
      SimpleDateFormat form = new SimpleDateFormat("MM-dd-yyyy hh:mm");
      String date = form.format(new Date());
      BTlist.add(new BankTransaction(date, type, amount, balance, info));

      for (BankTransaction bt : BTlist){
      try (BufferedWriter writer = new BufferedWriter(new FileWriter("history.txt", true))) {
         // Writing data to the file
         String line = bt.toString();
         writer.newLine();
         writer.write(line);
         writer.newLine();

      } catch (IOException e) {
         e.printStackTrace();
      }

   }
}

   public void printTabungan(){  

      System.out.printf("%-20s %-10s %-10s %-15s%n", "Date", "Amount", "Balance", "Type", "Information");
   System.out.println("--------------");
      for (BankTransaction bt : BTlist)
    { 
      try (BufferedReader reader = new BufferedReader(new FileReader("history.txt"))) {
         String line = bt.toString();

         // Reading data from the file
         while ((line = reader.readLine()) != null) {
             System.out.println(line);
         }
     } catch (IOException e) {
         e.printStackTrace();
     }
      System.out.println("--------------");
   }
   }
}