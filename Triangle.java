package problemOne;
//*********************************************
// Karthik Malyala
//
// A Triangle Class that encapsulates the concept of a triangle by defining the (x,y) coordinates of its three
// vertices. It includes private int instance variables for the three vertices and private double instances for the length of each
// side that are later used to generate the perimeter and area of the triangle through public methods.
//
//*********************************************

import java.lang.Math; // Needed for the round and square-root function

public class Triangle {
	
	// Defines the private instance variables for the triangle and its vertices
	private int x1, x2, x3;
	private int y1, y2, y3;
	private double side1, side2, side3;
	
	// No-arg constructor that defaults the values for each instance variable created above
	public Triangle() {
		x1 = 0;
		x2 = 0;
		x3 = 0;
		y1 = 0;
		y2 = 0;
		y3 = 0;
		side1 = 0;
		side2 = 0;
		side3 = 0;
	}
	
	// The mutator methods (setter methods) for the coordinates of the vertices 
	public void setx1 (int xone) {
		x1 = xone;
	}
	
	public void setx2 (int xtwo) {
		x2 = xtwo;
	}
	
	public void setx3 (int xthree) {
		x3 = xthree;
	}
	
	public void sety1 (int yone) {
		y1 = yone;
	}
	
	public void sety2 (int ytwo) {
		y2 = ytwo;
	}
	
	public void sety3 (int ythree) {
		y3 = ythree;
	}

	// The accessor methods (getter methods) for the coordinates of the vertices
	public int getx1() {
		return x1;
	}
	
	public int getx2() {
		return x2;
	}
	
	public int getx3() {
		return x3;
	}
	
	public int gety1() {
		return y1;
	}
	
	public int gety2() {
		return y2;
	}
	
	public int gety3() {
		return y3;
	}
	
	// The accessor methods for the side lengths side1, side2, and side3. Each respective method calculates, sets, and returns
	// the side length using the formula shown below

	public double getside1() {
		side1 = Math.round((Math.sqrt(Math.pow((x2-x1), 2)+ Math.pow((y2-y1), 2)))*100.0)/100.0;
		return side1;
	}
	
	public double getside2() {
		side2 = Math.round((Math.sqrt(Math.pow((x3-x1), 2)+ Math.pow((y3-y1), 2)))*100.0)/100.0;
		return side2;
	}
	
	public double getside3() {
		side3 = Math.round((Math.sqrt(Math.pow((x3-x2), 2)+ Math.pow((y3-y2), 2)))*100.0)/100.0;
		return side3;
	}
	
	// Public method to calculate the perimeter of the triangle using the sides generated above and the formula
	// P = A + B + C
	public double perimeter() {
		double perim = (side1 + side2 + side3);
		double roundedPerim = Math.round(perim*100.0)/100.0; // Rounds the perimeter found in the previous statement to two decimal places
		return roundedPerim;
	}
	// Public method to calculate the area of the triangle using the side, the perimeter generated above, and the
	// Heron's formula as shown below.
	public double area() {
		double h = perimeter()/2;
		double area = Math.sqrt(h*(h-side1)*(h-side2)*(h-side3));
		double roundedArea = Math.round(area*100.0)/100.0; // Rounds the area found in the previous statement to two decimal places
		return roundedArea;
	}
	
	// A toString() method that returns a well-formatted multi-line informational string for the triangle that lists the three 
	// vertices of a triangle
	public String toString() {
		String vertices = "Triangle Vertices are: \n";
		vertices += "Point 1: ("+x1+", "+y1+"), ";
		vertices += "Point 2: ("+x2+", "+y2+"), ";
		vertices += "Point 3: ("+x3+", "+y3+")";
		
		return vertices;
	}

}
