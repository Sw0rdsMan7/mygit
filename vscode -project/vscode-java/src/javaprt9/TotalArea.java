package javaprt9;

public class TotalArea {

	public static void main(String[] args)
	{
		Circle_[] circleArray;
		
		circleArray = createCircleArray();
		
		printCircleArray(circleArray);
         
	}

	private static Circle_[] createCircleArray() 
	{
	      Circle_[] circleArray = new Circle_[5];
	      
	      for(int i = 0;i < circleArray.length;i++ )
	      {
	    	  circleArray[1] = new Circle_();
	      }
	      
	      return circleArray;
	
	}
	
	public static void printCircleArray(Circle_[] circleArray)
	{
	    System.out.printf("%-30%-15sf\n","Radius","Area");
		for(int i = 0;i< circleArray.length;i++)
		{
		//	System.out.printf("%-30f%-15f\n",circleArray[i].getRadius(),
			//		circleArray[i].getArea());
			System.out.printf("__________________");
		
			System.out.printf("%-30s%-15f\n","The total area of circle is",
					sum(circleArray));
		}
	}
	
	public static double sum(Circle_[] circleArray)
	{
		double sum=0;
		
		for(int i=0;i<circleArray.length;i++)
			sum+= circleArray[i].getArea();
		
		return sum;
	}

}
