package javaprt11;

import java.util.Scanner;

public class T17runfile {
    public static int[] minsquare(int value){
         int []A=new int[100];
         while(value!=1){
             for(int i=2;i<=value;i++){
                 if(value%i==0)
                    {
                        A[i]++;
                        value/=i;
                        break;
                    }
             }
         }
         return A;

    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System .in);
        System.out.print("Enter an integer m:");    
        int value=input.nextInt();
        int[]B=minsquare(value);
        int num=1;
        
        for(int i=0;i<100;i++){
            if(B[i]!=0)
            if(B[i]%2==1)
                num*=i;
        }
        System.out.printf("The smallest number n for m*n to be a perfect squaren is %d\nm*n is %d ",num,num*value);

        input.close();

        
    }
}
