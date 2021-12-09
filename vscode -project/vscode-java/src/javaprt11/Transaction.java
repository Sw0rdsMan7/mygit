package javaprt11;

import java.util.Date;

public class Transaction {
    public Date date;
    public char type;
    public double amount;
    public double balance;
    public String description;
    Transaction(Date date,char type,double amount,double balance,String description){
        this.date=date;
        this.type=type;
        this.amount=amount;
        this.balance=balance;
        this.description=description;

    }

    
}