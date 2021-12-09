package javaprt11;

public class T8runfile {
    public static void main(String[] args) {
        Account account1=new Account("yj", 123, 1000, 1.5);
        account1.withDraw(200);
        account1.deposit(300);
        account1.withDraw(235);
        account1.printAccount();
    }
}
