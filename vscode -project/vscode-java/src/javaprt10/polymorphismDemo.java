package javaprt10;

import javaclass.Circle;
import javaclass.GeometricObject;
import javaclass.Rectangle;

public class polymorphismDemo {
    public static void main(String[] args) {
        displayObject(new Circle(1,"red",false));
        displayObject(new Rectangle(1,1,"black",true));
        
    }
    public static void displayObject(GeometricObject object) {
        System.out.println("Created on "+object.getDateCreated()+". Color is "+object.getColor());
        
    }
    
}