package prt1to8;
/*public class project2 {  //3.4

    public static void main(String[] args) {
       int a=(int)(Math.r&&om()*12);
       switch (a)
       {
            case 1
            System.out.println("January");
            break;
            case 2
            System.out.println("February");
            break;
            case 3
            System.out.println("March");
            break;
            case 4
            System.out.println("April");
            break;
            case 5
            System.out.println("May");
            break;
            case 6
            System.out.println("June");
            break;
            case 7
            System.out.println("July");
            break;
            case 8
            System.out.println("August");
            break;
            case 9
            System.out.println("September");
            break;
            case 10
            System.out.println("October");
            break;
            case 11
            System.out.println("November");
            break;
            case 12
            System.out.println("December");
            break;
       }
       
    }
}
*/
/*import java.util.Scanner;//3.9
public class project2 {  
    public static void main(String[] args) {
        System.out.print("Enter the first digits of an ISBN as integer ");
        Scanner input=new Scanner(System.in);
        long a=input.nextLong();
        System.out.print("The ISBN-10 number is ");
        long b=100000000;
        long c=0;
        int flag=1;
        while(a<b)
        {
            System.out.print("0");
            b/=10;
        }
        System.out.print(a);
        b=100000000;
        while(a!=0)
        {
            c+=(a/b)*flag;
            a=a%b;
            b/=10;
            flag++;
        }
        c=c%11;
        if(c==10)
            System.out.print("X");
        else
            System.out.print(c);
       input.close();
    }
}
*/
/*import java.util.Scanner;//3.15
public class project2 {  
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int lottery=(int)(Math.r&&om()*899+100);
        
        int lottery1=lottery/100;
        int lottery2=(lottery%100)/10;
        int lottery3=lottery%10;
        int x=input.nextInt();
        System.out.print("The lottery number is ");
        System.out.println(lottery);
        int x1=x/100;
        int x2=(x%100)/10;
        int x3=x%10;
        int flag=0;
        if(x1==lottery1)
        {
            lottery1=10;
            flag++;
        }
        else if(x1==lottery2)
        {
            lottery2=10;
            flag++;
        }
        else if(x1==lottery3)
        {
            lottery3=10;
            flag++;
        }
        if(x2==lottery1)
        {
            lottery1=10;
            flag++;
        }
        else if(x2==lottery2)
        {
            lottery2=10;
            flag++;
        }
        else if(x2==lottery3)
        {
            lottery3=10;
            flag++;
        }
        if(x3==lottery1)
        {
            lottery1=10;
            flag++;
        }
        else if(x3==lottery2)
        {
            lottery2=10;
            flag++;
        }
        else if(x3==lottery3)
        {
            lottery3=10;
            flag++;
        }
        if(x==lottery)
        {
            System.out.println("You will get 10000 dollars!");
        }
        else if(flag==3)
        {
            System.out.println("You will get 3000 dollars!");
        }
        else if(flag==1)
        {
            System.out.println("You will get 1000 dollars!");
        }
        else
        {
            System.out.println("Sorry,no match");
        }
        input.close();
    }
}*/
/*import java.util.Scanner;//3.19
public class project2 {  
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int a=input.nextInt();
        int b=input.nextInt();
        int c=input.nextInt();
        if(a+b>c&&a+c>b)
        {
            System.out.println(a+b+c);
        }
        else
        {
            System.out.println("input was not legal");
        }
        input.close();
    }
}*/
/*import java.util.Scanner;//3.21
public class project2 {  
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter year: ");
        int year=input.nextInt();
        System.out.print("Enter month: ");
        int mouth=input.nextInt();
        System.out.print("Enter day: ");
        int day=input.nextInt();
        if (mouth==1 || mouth==2)
            {
            mouth+=12;
            year-=1;
            }
        int k=year%100;
        int j=(int)(year/100);
        int h=(day+(26*(mouth+1)/10)+k+(k/4)+(j/4)+5*j)%7;
        if (h==0)
            System.out.println("Saturday");
        if (h==1)
            System.out.println("Sunday");
        if  (h==2)
            System.out.println("Monday");
        if (h==3)
            System.out.println("Tuesday");
        if (h==4)
            System.out.println("Wednesday");
        if (h==5)
            System.out.println("Thursday");
        if (h==6)
            System.out.println("Friday");
        input.close();
    }
}*/
/*import java.util.Scanner;//3.22
public class project2 {  
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int a=input.nextInt();
        int b=input.nextInt();
        if(Math.pow(Math.pow(a, 2.0)+Math.pow(b, 2.0),0.5)<10)
        {
            System.out.println("Yes");
        }
        else
            System.out.println("No");
    }
}*/
/*import java.util.Scanner;//3.23
public class project2 {  
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        double a=input.nextDouble();
        double b=input.nextDouble();
        if(Math.abs(a)<=5&&Math.abs(b)<=2.5)
        {
            System.out.println("Yes");
        }
        else
            System.out.println("No");
    }
}*/
/*import java.util.Scanner;//3.25
public class project2 {  
    public static void main(String[] args) {
        int a=(int)(Math.random()*13+1);
        int b=(int)(Math.random()*3+1);
        String card="";
        String card_colour="";
        switch (a)
        {
            case 1:
            card="Ace";
            switch(b)
            {
                case 1:
                card_colour="Clubs";
                break;
                case 2:
                card_colour="Diamonds";
                break;
                case 3:
                card_colour="Hearts";
                break;
                case 4:
                card_colour="Spades";
                break;
            }
            break;
            case 2:
            card="2";
            switch(b)
            {
                case 1:
                card_colour="Clubs";
                break;
                case 2:
                card_colour="Diamonds";
                break;
                case 3:
                card_colour="Hearts";
                break;
                case 4:
                card_colour="Spades";
                break;
            }
            break;
            case 3:
            card ="3";
            switch(b)
            {
                case 1:
                card_colour="Clubs";
                break;
                case 2:
                card_colour="Diamonds";
                break;
                case 3:
                card_colour="Hearts";
                break;
                case 4:
                card_colour="Spades";
                break;
            }
            break;
            case 4:
            card="4";
            switch(b)
            {
                case 1:
                card_colour="Clubs";
                break;
                case 2:
                card_colour="Diamonds";
                break;
                case 3:
                card_colour="Hearts";
                break;
                case 4:
                card_colour="Spades";
                break;
            }
            break;
            case 5:
            card="5";
            switch(b)
            {
                case 1:
                card_colour="Clubs";
                break;
                case 2:
                card_colour="Diamonds";
                break;
                case 3:
                card_colour="Hearts";
                break;
                case 4:
                card_colour="Spades";
                break;
            }
            break;
            case 6:
            card="6";
            switch(b)
            {
                case 1:
                card_colour="Clubs";
                break;
                case 2:
                card_colour="Diamonds";
                break;
                case 3:
                card_colour="Hearts";
                break;
                case 4:
                card_colour="Spades";
                break;
            }
            break;
            case 7:
            card="7";
            switch(b)
            {
                case 1:
                card_colour="Clubs";
                break;
                case 2:
                card_colour="Diamonds";
                break;
                case 3:
                card_colour="Hearts";
                break;
                case 4:
                card_colour="Spades";
                break;
            }
            break;
            case 8:
            card="8";
            switch(b)
            {
                case 1:
                card_colour="Clubs";
                break;
                case 2:
                card_colour="Diamonds";
                break;
                case 3:
                card_colour="Hearts";
                break;
                case 4:
                card_colour="Spades";
                break;
            }
            break;
            case 9:
            card="9";
            switch(b)
            {
                case 1:
                card_colour="Clubs";
                break;
                case 2:
                card_colour="Diamonds";
                break;
                case 3:
                card_colour="Hearts";
                break;
                case 4:
                card_colour="Spades";
                break;
            }
            break;
            case 10:
            card="10";
            switch(b)
            {
                case 1:
                card_colour="Clubs";
                break;
                case 2:
                card_colour="Diamonds";
                break;
                case 3:
                card_colour="Hearts";
                break;
                case 4:
                card_colour="Spades";
                break;
            }
            break;
            case 11:
            card="Jack";
            switch(b)
            {
                case 1:
                card_colour="Clubs";
                break;
                case 2:
                card_colour="Diamonds";
                break;
                case 3:
                card_colour="Hearts";
                break;
                case 4:
                card_colour="Spades";
                break;
            }
            break;
            case 12:
            card="Queen";
            switch(b)
            {
                case 1:
                card_colour="Clubs";
                break;
                case 2:
                card_colour="Diamonds";
                break;
                case 3:
                card_colour="Hearts";
                break;
                case 4:
                card_colour="Spades";
                break;
            }
            break;
            case 13:
            card ="King";
            switch(b)
            {
                case 1:
                card_colour="Clubs";
                break;
                case 2:
                card_colour="Diamonds";
                break;
                case 3:
                card_colour="Hearts";
                break;
                case 4:
                card_colour="Spades";
                break;
            }
            break;
            
        }    
        System.out.println("The card you picked is "+card+" of "+card_colour);
    }

}*/
/*import java.util.Scanner;//3.26

public class project2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a point's x- and y-coordinates: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        if (b < a *(-1.0/2) + 100 && b > 0 && a > 0)
            System.out.println("The point is in the triangle");
        else
            System.out.println("The point is not in the triangle");

        input.close();
    }
}*/
/*import java.util.Scanner;//3.28
public class project2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter r1's center x-, y-coordinates, width and height:");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double width1 = input.nextDouble();
        double height1 = input.nextDouble();
        System.out.println("Enter r1's center x-, y-coordinates, width and height:");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double width2 = input.nextDouble();
        double height2 = input.nextDouble();
        if (x1 + width1 / 2 >= x2 + width2 / 2 && x1 - width1 / 2 <= x2 - width2 / 2
                && y1 - height1 / 2 <= y2 - height2 / 2 && y1 + height1 / 2 >= y2 + height2 / 2) {
            System.out.println("r2 is inside r1");

        } else if (x2 + width2 / 2 > x1 + width1 / 2 || x2 - width2 / 2 < x1 - width1 / 2
                || y1 - height1 / 2 < y2 - height2 / 2 || y1 + height1 / 2 > y2 + height2 / 2) {
            if (x2 + width2 / 2 < x1 + width1 / 2 && x2 + width2 > x1 - width1
                    || x2 - width2 / 2 < x1 + width1 / 2 && x2 - width2 > x1 - width1
                    || y2 + height2 / 2 < y1 + height1 / 2 && y2 + height2 > y1 - height1
                    || y2 - height2 / 2 < y1 + height1 / 2 && y2 - height2 > y1 - height1)
                System.out.println("r2 is overlap r1");
            else {
                System.out.println("r2 is not overlap r1");
            }

        }
    }
}*/
/*import java.util.Scanner;//3.29
public class project2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter circle1's center  x-,  y-coordinates, and radius: ");
        double circle1_x = input.nextDouble();
        double circle1_y = input.nextDouble();
        double circle1_radius = input.nextDouble();
        System.out.print("Enter circle2's center  x-,  y-coordinates, and radius: ");
        double circle2_x = input.nextDouble();
        double circle2_y = input.nextDouble();
        double circle2_radius = input.nextDouble();
        double distance = Math.pow(Math.pow(circle2_x-circle1_x,2.0)+Math.pow(circle1_y-circle2_y,2.0),0.5);  
        if(circle2_radius+distance<circle1_radius)
            System.out.println("circle2 is inside circle1");
        else if (distance<circle1_radius+circle2_radius&&circle2_radius<circle1_radius)
            System.out.println("circle2 overlaps circle1");
        else
         System.out.println("circle2 does not overlaps circle1");

        input.close();
    }
}*/
/*import java.util.Scanner;//5.7
public class project2 {
    public static void main(String[] args) {
       double a=10000;
       double sum=10000;
        for(int i=0;i<=13;i++)
        {
            if(i<=9)
            {
                a=a*1.05;
            }
            else
            {
                a=a*1.05;
                sum+=a; 
            }
        }
        System.out.printf("%.2f",sum);
    }
}*/
/*import java.util.Scanner;//5.17
public class project2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= a; j++) {
                if (a - j < i)
                    System.out.printf("%-2d", a - j + 1);
                else
                    System.out.print("  ");
            }
            for (int j = 2; j <= a; j++) {
                if (i >= j && j != 2) {
                    System.out.printf("%2d", j);
                } else if (j == 2 && i >= j) {
                    System.out.print(j);
                }

            }
            System.out.println("");
        }
        input.close();
    }
}*/
/*import java.util.Scanner;//5.19

public class project2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= a; j++) {
                if (a - j < i)
                    System.out.printf("%-4d", (int)(Math.pow(2, i-a+j-1)));
                else
                    System.out.print("    ");
            }
            for (int j = 2; j <= a; j++) {
                if (i >= j && j != 2) {
                    System.out.printf("%-4d", (int)(Math.pow(2, i-j)));
                } else if (j == 2 && i >= j) {
                    System.out.printf("%-4d", (int)(Math.pow(2, i-j)));
                }

            }
            System.out.println("");
        }
        input.close();
    }
}*/
/*import java.util.Scanner;//5.21
public class project2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Loan Amount: ");
        double Loan_amount = input.nextDouble();
        System.out.print("Number of Years: "); 
        int num_year=input.nextInt();
        double mouthlyInterestRate=0.0;
        for(double i=5.0;i<=8.0;i+=0.125)
        {
            mouthlyInterestRate=i/1200;
            double mouthlyPayment=Loan_amount*mouthlyInterestRate/(1-1/Math.pow(1+mouthlyInterestRate, num_year*12));
            double totalPayment =mouthlyPayment*12*num_year;
            System.out.printf("%.2f %.2f\n",mouthlyPayment,totalPayment);
        }


        input.close();
        }
        
    }*/
/*import java.util.Scanner;//5.22

public class project2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Loan Amount: ");
        double Loan_amount = input.nextDouble();
        System.out.print("Number of Years: ");
        int num_year = input.nextInt();
        System.out.print("Annual Interest Rate:");
        double Annualinterest = input.nextDouble();
        double mouthlyInterestRate = Annualinterest / 1200;
        double mouthlyPayment = Loan_amount * mouthlyInterestRate
                / (1 - 1 / Math.pow(1 + mouthlyInterestRate, num_year * 12));
        double totalPayment = mouthlyPayment * 12 * num_year;
        System.out.printf("Mouthly Payment:%.2f Total Payment::%.2f\n", mouthlyPayment, totalPayment);
        double balance = Loan_amount;
        double Interest = 0;
        double principal = 0;
        for (double i = 1; i <= 12 * num_year; i++) {
            Interest = mouthlyInterestRate * balance;
            principal = mouthlyPayment - Interest;
            balance = balance - principal;
            System.out.println(i + "\t\t" + Interest + "\t\t" + principal + "\t\t" + balance);

        }

        input.close();
    }

}*/
/*import java.util.Scanner;//5.25

public class project2 {
    public static void main(String[] args) {
        double sum=0;
        for(int j=1;j<=10;j++){
            sum=0;
            for(int i=1;i<=10000;i++){
                sum+=Math.pow(-1, i+1)/(2*i-1);
            }
            sum*=4;
            System.out.println(sum);
            
        }
        

        
    }

}*/
/*public class project2 {//5.26
    public static void main(String[] args) {
        double sum=0;
        double flag=1;
        for(int j=1;j<=10;j++){
            sum=0;
            for(int i=0;i<=10000*j;i++){
                flag=1;
                for(int x=1;x<=i;x++){
                    flag*=x;
                }
                sum+=(double)(1/flag);   
            }
            System.out.println(sum);
            
        }
        

        
    }

}*/
/*public class project2 {// 5.27
    public static void main(String[] args) {
        int flag1=0;
        int flag2=0;
        for(int i=201;i<=2020;i++){
            if(i%4==0 && i%100!=0){
                System.out.printf("%d ",i);
                flag1++;
                flag2++;
                if(flag1==10){
                    System.out.println();
                    flag1=0;
                }
            }
            else if(i%100==0 && i%400 ==0){
                System.out.printf("%d ",i);
                flag1++;
                flag2++;
                if(flag1==10){
                    System.out.println();
                    flag1=0;
                }
            }
            
            }
            System.out.print("\n");
            System.out.print(flag2);
            
        

        
    }

}*/
/*import java.util.Scanner;//5.28

public class project2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter year: ");
        int year = input.nextInt();
        System.out.print("Enter first day is : ");
        int week = input.nextInt();
        int flag = 0;
        String day = "";
        String mouth = "January";
        if (year % 4 == 0 && year % 100 != 0)
            flag = 1;
        else if (year % 100 == 0 && year % 400 == 0)
            flag = 1;
        for (int i = 1; i <= 12; i++) {
            if (week == 1) {
                day = "Monday";
            } else if (week == 2) {
                day = "Tuesday";
            } else if (week == 3) {
                day = "Wednesday";
            } else if (week == 4) {
                day = "Thursday";
            } else if (week == 5) {
                day = "Friday";
            } else if (week == 6) {
                day = "Saturday";
            } else {
                day = "Sunday";
            }
            System.out.printf("%s 1 %d, is %s\n", mouth, year, day);
            if (i == 1) {
                week = (week + 31) % 7;
                mouth = "February";
            } else if (i == 2) {
                if (flag == 1)
                    week = (week + 29) % 7;
                else
                    week = (week + 28) % 7;
                mouth = "March";
            } else if (i == 3) {
                week = (week + 31) % 7;
                mouth = "April";
            } else if (i == 4) {
                week = (week + 30) % 7;
                mouth = "May";
            } else if (i == 5) {
                week = (week + 31) % 7;
                mouth = "June";
            } else if (i == 6) {
                week = (week + 30) % 7;
                mouth = "July";
            } else if (i == 7) {
                week = (week + 31) % 7;
                mouth = "August";
            } else if (i == 8) {
                week = (week + 31) % 7;
                mouth = "September";
            } else if (i == 9) {
                week = (week + 30) % 7;
                mouth = "October";
            } else if (i == 10) {
                week = (week + 31) % 7;
                mouth = "November";
            } else if (i == 11) {
                week = (week + 30) % 7;
                mouth = "December";
            }
        }
        input.close();
    }
}*/
/*import java.util.Scanner;//5.29
public class project2{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter year: ");
        int year = input.nextInt();
        System.out.print("Enter first day is : ");
        int week = input.nextInt();
        int flag = 0;
        String day = "";
        String mouth = "January";
        int mouth_day=31;
        if (year % 4 == 0 && year % 100 != 0)
            flag = 1;
        else if (year % 100 == 0 && year % 400 == 0)
            flag = 1;
        for (int i = 1; i <= 12; i++) {
            if (week == 1) {
                day = "Monday";
            } else if (week == 2) {
                day = "Tuesday";
            } else if (week == 3) {
                day = "Wednesday";
            } else if (week == 4) {
                day = "Thursday";
            } else if (week == 5) {
                day = "Friday";
            } else if (week == 6) {
                day = "Saturday";
            } else {
                day = "Sunday";
            }
            System.out.printf("         %s  %d\nSun  Mon  Tue  Wed  Thu  Fri  Sat  \n", mouth, year);
            if (i == 1) {
                week = (week + 31) % 7;
                mouth = "February";
                mouth_day=31;
            } else if (i == 2) {
                if (flag == 1){
                    week = (week + 29) % 7;
                    mouth_day=29;
                }else{
                    week = (week + 28) % 7;
                    mouth_day=28;
                }mouth = "March";
            } else if (i == 3) {
                week = (week + 31) % 7;
                mouth = "April";
                mouth_day=31;
            } else if (i == 4) {
                week = (week + 30) % 7;
                mouth = "May";
                mouth_day=30;
            } else if (i == 5) {
                week = (week + 31) % 7;
                mouth = "June";
                mouth_day=31;
            } else if (i == 6) {
                week = (week + 30) % 7;
                mouth = "July";
                mouth_day=30;
            } else if (i == 7) {
                week = (week + 31) % 7;
                mouth = "August";
                mouth_day=31;
            } else if (i == 8) {
                week = (week + 31) % 7;
                mouth = "September";
                mouth_day=31;
            } else if (i == 9) {
                week = (week + 30) % 7;
                mouth = "October";
                mouth_day=30;
            } else if (i == 10) {
                week = (week + 31) % 7;
                mouth = "November";
                mouth_day=31;
            } else if (i == 11) {
                week = (week + 30) % 7;
                mouth = "December";
                mouth_day=30;
            }else{
                mouth_day=31;
            }
            for(int x=1;x<=week%7;x++){
                System.out.print("     ");
            }
            for(int j=1;j<=mouth_day;j++){
                
                System.out.printf("%-5d",j);
                week=(week+1)%7;
                if(week==0)
                    System.out.print("\n");


            }

            System.out.print("\n");
        }
       
    }
}*/
/*import java.util.Scanner;//5.32
public class project2{
    public static void main(String[] args){
        int a=(int)(Math.random()*10);
        while(a==0){
            a=(int)(Math.random()*10);
        }
        int b=(int)(Math.random()*10);
        while(a==b){
            b=(int)(Math.random()*10);
        }    
        System.out.printf("%d %d",a,b);
    }
}*/
/*import java.util.Scanner;//5.33
public class project2 {
    public static void main(String[] args) {
        int[] a = new int[10000];
        Scanner input = new Scanner(System.in);
        int flag = 0;
        int sum = 0;
        for (int y = 1; y <= 10000; y++) {
            sum=0;
            flag=0;
            for (int i = 1; i < y; i++) {
                if (y % i == 0) {
                    a[flag] = i;
                    flag++;
                }
            }
            for (int i = 0; i < flag; i++) {
                sum += a[i];
            }
            if (sum == y)
                System.out.println(y);
        }

        input.close();
    }
}*/
/*import java.util.Scanner;//5.36
public class project2 {
    public static void main(String[] args) {

        System.out.print("Enter the first digits of an ISBN as integer ");
        Scanner input = new Scanner(System.in);
        long a = input.nextLong();
        System.out.print("The ISBN-10 number is ");
        long b = 100000000;
        long c = 0;
        int flag = 1;
        while (a < b) {
            System.out.print("0");
            b /= 10;
        }
        System.out.print(a);
        b = 100000000;
        while (a != 0) {
            c += (a / b) * flag;
            a = a % b;
            b /= 10;
            flag++;
        }
        c = c % 11;
        if (c == 10)
            System.out.print("X");
        else
            System.out.print(c);
        input.close();

    }
}*/
/*import java.util.Scanner;//5.37
public class project2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int []a=new int[100];
        int flag=0;
        while(x!=0){
            a[flag]=x%2;
            flag++;
            x/=2;
        }
        for(int i=flag-1;i>=0;i--){
            System.out.print(a[i]);
        }
        input.close();
    }
}*/
/*import java.util.Scanner;//5.38
public class project2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int []a=new int[100];
        int flag=0;
        while(x!=0){
            a[flag]=x%8;
            flag++;
            x/=8;
        }
        for(int i=flag-1;i>=0;i--){
            System.out.print(a[i]);
        }
        input.close();
    }
}*/
/*import java.util.Scanner;//5.45
public class project2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double []a=new double[10];
        double sum1=0;
        double sum2=0;
        for(int i=0;i<=9;i++){
            System.out.print("Enter a number: ");
            a[i]=input.nextDouble();
            sum1+=a[i];
            sum2+=Math.pow(a[i], 2);
        }
        System.out.printf("The mean is %.2f\nThe Standard deviation is %.2f",sum1/10,Math.pow((sum2-Math.pow(sum1, 2)/10)/9, 0.5));





        input.close();
    }
}*/