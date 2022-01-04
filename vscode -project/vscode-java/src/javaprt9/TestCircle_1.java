package sixth_task;

public class TestCircle_1 {
    public static void main (String[] args)
    {
  //Create a circle with radius 1
   	Circle_ circle1 = new Circle_();
   	System.out.println("The area of the circle of radius" 
   	 + circle1.radius + " is " + circle1.getArea() );
   	
   	//Create a circle with radius 25
    Circle_ circle2= new Circle_(25);
   	System.out.println("The area of the circle of radius" 
   	 + circle2.radius + " is " + circle2.getArea() );
   	
   	//Create a circle with radius 125
    Circle_ circle3= new Circle_(125);
   	System.out.println("The area of the circle of radius" 
   	 + circle3.radius + " is " + circle3.getArea() );
   	   	
   	// Modify circle radius
   	circle2.radius = 100;
 	System.out.println("The area of the circle of radius" 
 	 + circle2.radius + " is " + circle2.getArea() );
 		   	
    }
}
