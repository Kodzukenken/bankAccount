import java.util.Scanner;

public class BankAccountTester{
   public static void main(String[] args){   

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
         System.out.println("--------------"); 
         System.out.println("Menu");
         System.out.println("--------------");
         System.out.println("1. Create an account");
         System.out.println("2. Deposit");
         System.out.println("3. Withdraw");
         System.out.println("4. Display Bank Book Transaction");
         System.out.println("5. Exit");
         System.out.println("--------------");
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