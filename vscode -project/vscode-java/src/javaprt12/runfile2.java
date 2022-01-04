package javaprt12;

import java.util.Scanner;

import java.util.TreeSet;

public class runfile2 {
    public static void main(String[] args) {
        int flag=0;
        Scanner input=new Scanner(System.in);
        TreeSet<Student> students=new TreeSet<>();
        String number="";
        String name="";
        int year=0;
        do{
            String string1=input.nextLine();
            if(flag==0)
            String number=string1;
            else if{
                String name=input.nextLine();
                int year=input.nextInt();

            }
           
            students.add(new Student(number,name,year));
        }while(input.nextLine()!="exit\n");
        students.forEach(e->System.out.print(e));
        input.close();
    }
}
