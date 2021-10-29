
/*import java.util.Scanner;//7.3
public class project3 {
     public static void main(String[] args) {
         Scanner input=new Scanner(System.in);
         int []a=new int[100];
         int b=0;
         String flag="";
         for(int i=0;i<=9;i++){
             System.out.print("Enter a number between 1 to 100: ");
             b=input.nextInt();
             a[b]++;
         }
         for(int i=1;i<=99;i++){
            if(a[i]!=0){
                if(a[i]>1)
                flag="times";
                else
                flag="time";
                System.out.printf("%d occurs %d %s\n",i,a[i],flag);
            }
         }
         input.close();
        
    }
}*/
/*import java.util.Scanner;//7.5

public class project3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] a = new int[100];
        int b = 0;
        int flag = 0;
        int flag2 = 0;
        for (int i = 0; i <= 9; i++) {
            flag2 = 0;
            System.out.print("Enter a number : ");
            b = input.nextInt();
            for (int j = 0; j < flag; j++) {
                if (b == a[j]) {
                    flag2 = 1;
                    break;
                }
            }
            if (flag2 == 0) {
                a[flag] = b;
                flag++;
            }

            
        }
        input.close();
        System.out.printf("The number of distinct is %d\n",flag);
        System.out.print("The distinct numbers are: ");
        for(int x=0;x<=flag-1;x++){
            System.out.printf("%d ",a[x]);
        }

    }
}*/
/*import java.util.Scanner;

public class project3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] a = new int[10][10];
        int num = input.nextInt();
        int max = 0;
        int max_index = 0;
        for (int i = 0; i <= num - 1; i++) {
            for (int j = 0; j <= 6; j++) {
                a[i][j] = input.nextInt();
                a[i][7] += a[i][j];
            }
        }
        for (int x = 0; x <= num; x++) {
            max = 0;
            for (int i = 0; i <= num - 1; i++) {    
                
                if (a[i][7] > max) {
                    max = a[i][7];
                    max_index = i;
                }
            }
            System.out.printf("Employee %d    ", max_index);
            for (int j = 0; j <= 6; j++) {
                System.out.printf("%-4d", a[max_index][j]);
            }
            System.out.print("\n");
            a[max_index][7] = 0;
        }

        a[max_index][7] = 0;
        input.close();
    }
}*/
