package javaprt9;

public class Circle_ {
	
		double radius;
        Circle_()
        {
        	
        
        }
		Circle_(double newRadius)
		{
			radius=newRadius;
		}
		// Return the area of this circle 
		double getArea()
		{
			return radius * radius * Math.PI;
		}
		
		// Return the perimeter of this circle 
		double getPerimeter()
		{
			return 2*radius*Math.PI;
		}
		
		// Set a new radius for this circle
		void setRadius(double newRadius)
		{
			radius = newRadius;
		}
}
