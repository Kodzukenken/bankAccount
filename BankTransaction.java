import java.text.SimpleDateFormat;
import java.util.Date;

class BankTransaction{
   private String date;
   private String typeTransaction;
   private double amountTransaksi;
   private double balanceTransaksi;
   private String info;

   public BankTransaction(String date, String typeT, double amountT, double balanceT, String info)
   { 
    // typeTransaction = typeT;
    //  amountTransaksi = amountT;
    //  balanceTransaksi = balanceT;
    this.date = date;
    this.typeTransaction = typeT;
    this.amountTransaksi = amountT;
    this.balanceTransaksi = balanceT;
    this.info = info;
   } 
   
   public String toString() {
    return String.format("%-20s %-10.2f %-10.2f %-15s", date, amountTransaksi, balanceTransaksi, typeTransaction, info);
}
 
}
 