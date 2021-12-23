package javaprt11;

import java.util.Scanner;

public class T19runfile {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        
        int A[]=new int[100];
        System.out.print("Enter the number of objects: ");
        int number1=input.nextInt();
        int printnum=0;
        int printB[]=new int[10];
        System.out.print("The weights of the objects: ");
        for(int i=0;i<=number1-1;i++){
            A[i]=input.nextInt();
            if(printnum+A[i]>10){
                for(int j=0;j<=9;j++){
                    while(printB[j]>0){
                        System.out.print(j);
                        printB[j]--;
                    }
                }
                printnum=A[i];
                printB[A[i]]+=1;
                
            }
            else{
                printnum+=A[i];
                printB[A[i]]+=1;
            }
        }
        if (printnum>0){
            System.out.println(printnum);
        }
        input.close();
    }
    
}
