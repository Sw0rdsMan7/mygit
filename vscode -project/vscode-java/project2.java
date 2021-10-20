
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
        Scanner input =new Scanner(System.in);
       int a=input.nextInt();
       for(int i=1;i<=a;i++)
       {
            for(int j=1;j<=7;j++)
            {
                if(7-j<i)
                System.out.printf("%-2d",7-j+1);
                else
                System.out.print("  ");
            }
            for(int j=2;j<=7;j++)
            {
                if(i>=j&&j!=2)
                {
                    System.out.printf("%2d",j);
                }
                else if(j==2&&i>=j)
                {
                    System.out.print(j);
                }
                
            }
            System.out.println("");
       }
        input.close();
    }
}*/