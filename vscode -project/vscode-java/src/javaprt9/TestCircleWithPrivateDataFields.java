package javaprt9;

public class TestCircleWithPrivateDataFields {

	public static void main(String[] args) {
		Circle myCircle = new Circle();
		System.out.println("The area of the circle of radius "
				+ myCircle.getRadius() + " is " + myCircle.getArea());
		
		myCircle.setRadius(myCircle.getRadius() * 1.1);
		System.out.println("The area of the circle of radius "
				+ myCircle.getRadius() + " is " + myCircle.getArea());
		
		//System.out.println("The number of object created is " 
		//		+ Circle.getNumberOfObject());
		
	}

}
