package javaprt11;

import java.util.ArrayList;
import java.util.Scanner;

public class T16runfile {
    public static void main(String[] args) {
        int number1=(int)(Math.random()*10);
        int number2=(int)(Math.random()*10);
        int flag=0;
        ArrayList<Integer>a=new ArrayList<>();
        Scanner input=new Scanner(System.in);
        
        System.out.print("What is "+number1 +"+"+number2+"? " );
        int answer=input.nextInt();
        while(number1+number2!=answer){
            for(int i=a.size()-1;i>=0;i--){
                int b=a.get(i);
                if(answer==b){
                    System.out.println("You have already input "+answer);
                    flag=1;
                    break;
                }
            }
            a.add(answer);
            if(flag==0){
                System.out.print("Wrong answer. Try again. What is "+
                number1+"+"+number2 +"?" );
                answer=input.nextInt();
            }
            else{
                flag=0;
                answer=input.nextInt();
                
            }
        }
        System.out.print("You got it!");
        input.close();
    }
    
}
