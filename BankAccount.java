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
   private double balance;;
   private ArrayList<BankTransaction> BTlist = new  ArrayList<BankTransaction>();
   private ArrayList<BankAccount> AccList = new ArrayList<BankAccount>();
   
   public BankAccount()
   {   
      balance = 0;
   } 

   public BankAccount(double initialBalance, String name)
   {  this.name = name;
      this.balance = initialBalance;
   }

   public void create(String name, double initialBalance){

   }

   public void deposit(double amount){
      this.balance += amount;
      newTransaction(amount, "n/a", "Deposit");
   } 

   public void withdraw(double amount)
   { 
      if (amount >= balance) {
      System.out.println("You don't have enough balance");
   } else {
      this.balance -= amount;
      newTransaction(amount, "n/a", "Withdraw");
      }
   }
   
   public void transfer(double amount, BankAccount recipient, String info) {

      // Perform the transfer if both accounts are found
      // if (recipientAccount != null) {
          // Withdraw from the source account
          if (amount >= this.balance) {
         System.out.println("You don't have enough balance");
           } else {
            this.balance -= amount;

         }
          // Deposit into the recipient account
          recipient.deposit(amount);
  
          // Log the transaction
          newTransaction(amount, info, "Transfer");
  
          System.out.println("Successful Transfer");
      // } else {
      //     System.out.println("Cannot Transfer. Source or recipient account not found.");
      // }
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

   public void addAccount(String name, double balance){
      AccList.add(new BankAccount(balance, name));
   }

   private void newTransaction(double amount, String info, String type){
      SimpleDateFormat form = new SimpleDateFormat("MM-dd-yyyy hh:mm");
      String date = form.format(new Date());
      BTlist.add(new BankTransaction(date, type, balance, amount, info));

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

   System.out.println("--------------");
   // System.out.printf("%-20s %-10s %-10s %-15s %-20s", "Date", "Amount", "Balance", "Type", "Information");
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