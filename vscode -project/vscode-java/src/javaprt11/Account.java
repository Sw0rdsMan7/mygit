
package javaprt11;

import java.util.Date;
import java.util.ArrayList;

public class Account{
    private String name;
    private int id;
    private ArrayList<Transaction> transactions;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    Account(String name , int id ,double balance,double annualInterestRate){
        this.dateCreated=new Date();
        this.name =name;
        this.id=id;
        this.balance=balance;
        this.annualInterestRate=annualInterestRate;
        this.transactions=new ArrayList<Transaction>();
        this.transactions.add(new Transaction(dateCreated, 'D',this.balance ,this.balance,"deposit"));
       }
    public void withDraw (double amount){
        Date d=new Date();
        this.balance=this.balance-amount;
        this.transactions.add(new Transaction(d, 'W',amount ,this.balance,"deposit"));
    }
    public void deposit(double amount){
        Date d=new Date();
        this.balance+=amount;
        this.transactions.add(new Transaction(d, 'D',amount ,this.balance,"deposit"));
    }
    public void printAccount(){
        System.out.print("Name :"+this.name);
        System.out.print("  Id :");
        System.out.print(id);
        System.out.printf("  Balance: %.2f", this.balance);
        System.out.printf("  Annual interest rate is :%.2f",this.annualInterestRate);
        System.out.println("%");
        for(int i=transactions.size()-1;i>=0;i--){
            Transaction a=transactions.get(i);
            System.out.print("Date :");
            System.out.print(a.date);
            System.out.print("  Type:");
            System.out.print(a.type);
            System.out.print("  Amount:");
            System.out.print(a.amount);
            System.out.print("  Balance:");
            System.out.print(a.balance);
            System.out.print("\n");

            
        }

        
    }

    
}