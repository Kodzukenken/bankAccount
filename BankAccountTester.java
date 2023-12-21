import java.util.Scanner;

public class BankAccountTester{
   public static void main(String[] args){   

      int opt, amt;
      String name, info, rec;

      Scanner button = new Scanner(System.in);

      System.out.println("Please enter your name: ");
      name = button.nextLine();
      System.out.println("Enter your initial balance: ");
      amt = button.nextInt();
      BankAccount account1 = new BankAccount(amt, name);
      BankAccount account2 = new BankAccount(amt, rec);
      account1.addAccount(name, amt);
      

      do{ 
         System.out.println("\nCurrent Account: ");
         System.out.println(account1.getName());
         System.out.println("--------------"); 
         System.out.println("Menu");
         System.out.println("--------------");
         System.out.println("1. Create an account");
         System.out.println("2. Deposit");
         System.out.println("3. Withdraw");
         System.out.println("4. Transfer to another account");
         System.out.println("5. Display bank Book Transaction");
         System.out.println("6. Exit");
         System.out.println("--------------");
         opt = button.nextInt();
 

      switch(opt){
         case 1:   
         //Creating an account
            System.out.println("Please enter your name: ");
            rec = button.nextLine();
            button.nextLine();
            System.out.println("Enter your initial balance: ");
            amt = button.nextInt();
            account2.addAccount(name, amt);
      break;
         case 2:
         // Deposit
            System.out.println("Please enter amount to deposit: ");
            amt = button.nextInt();
            account1.deposit(amt);
      break;
         case 3:
         // Withdraw
            System.out.println("Please enter amount to withdraw: ");
            amt = button.nextInt();
            account1.withdraw(amt);
      break;
         case 4:
         //Transfer
            System.out.println("Please enter the recipient account: ");
            rec = button.nextLine();
            button.nextLine();
            System.out.println("Please enter amount to transfer: ");
            amt = button.nextInt();
            button.nextLine();
            System.out.println("Please enter transfer information: ");
            info = button.nextLine();
            button.nextLine();

            account1.transfer(amt, rec, info);
      break;
         case 5:
         //Printing transaction history
            account1.printTabungan();
      break;
         default:
         ;
      }
      }while (opt != 6 || opt > 6 || opt < 1);


   }
}