package javaprt9;

public class Circle_2 {
	double radius;
	
	static int numberOfObjects = 0;
	
	Circle_2()
	{
		radius=1;
		numberOfObjects++;
	}
	
	Circle_2(double newRadius)
	{
		radius = newRadius;
		numberOfObjects++;
	}
	
	static int getNumberOfObjects()
	{
		return numberOfObjects;
	}

	double getArea()
	{
		return radius * radius * Math.PI;
	}
}
