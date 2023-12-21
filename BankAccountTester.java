import java.util.Scanner;

public class BankAccountTester{
   public static void main(String[] args){   

      int opt, amt;
      String name, info;

      Scanner button = new Scanner(System.in);

      System.out.println("Please enter your name: ");
      name = button.nextLine();
      System.out.println("Enter your initial balance: ");
      amt = button.nextInt();
      BankAccount acc = new BankAccount(amt, name);
      acc.addAccount(name, amt);

      do{ 
         System.out.println("\n--------------"); 
         System.out.println("Menu");
         System.out.println("--------------");
         System.out.println("1. Create an account");
         System.out.println("2. Deposit");
         System.out.println("3. Withdraw");
         System.out.println("4. Display bank Book Transaction");
         System.out.println("5. Transfer to another account");
         System.out.println("6. Exit");
         System.out.println("--------------");
         opt = button.nextInt();

      switch(opt){
         case 1:   
         //Creating an account
            System.out.println("Please enter your name: ");
            name = button.nextLine();
            System.out.println("Enter your initial balance: ");
            amt = button.nextInt();
            BankAccount cust2 = new BankAccount(amt, name);
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
         System.out.println("Please enter the recipient account: ");
         name = button.nextLine();
         System.out.println("Please enter amount to transfer: ");
         amt = button.nextInt();
         System.out.println("Please enter transfer information: ");
         info = button.nextLine();

         acc.transfer(amt, cust2, info);

      break;
         case 5:
         //Printing transaction history
            acc.printTabungan();
      break;
         default:
         ;
      }
      }while (opt != 6 || opt >6 || opt < 1);


   }
}