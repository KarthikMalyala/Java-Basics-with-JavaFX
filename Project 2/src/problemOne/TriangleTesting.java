package problemOne;
//*********************************************
// Karthik Malyala
//
// A test program that creates a Triangle object from the previous class created and prompts the user for coordinate values for the vertices and
// then displays the sides, perimeter, and area using the methods generated in the Triangle class
//
//*********************************************


import java.util.Scanner; // Needed to read input from the user

public class TriangleTesting {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner (System.in); // Creates an object of the Scanner class to read in the user's input
		Triangle triangle = new Triangle(); // Creates an object of the Triangle class to access the methods required to calculate the sides, perimeter, and area
		
		// Prompts the user for the coordinates of the first vertex and scans the x and y coordinates separately 
		System.out.println("Enter the coordinates of a triangle's first vertex: ");
		triangle.setx1(scan.nextInt());
		triangle.sety1(scan.nextInt());
		
		// Prompts the user for the coordinates of the second vertex and scans the x and y coordinates separately 
		System.out.println("Enter the coordinates of a triangle's second vertex: ");
		triangle.setx2(scan.nextInt());
		triangle.sety2(scan.nextInt());
		
		// Prompts the user for the coordinates of the third vertex and scans the x and y coordinates separately 
		System.out.println("Enter the coordinates of a triangle's third vertex: ");
		triangle.setx3(scan.nextInt());
		triangle.sety3(scan.nextInt());
		
		// Calls the toString() method of the Triangle class using the triangle object to print out the well-formatted string
		// that lists the three vertices of the triangle.
		System.out.println(triangle.toString());
		
		// Uses the getter or accessor methods in the Triangle class to generate the side lengths of the triangle and uses string
		// concatenation to list them out
		System.out.println("The Triangle sides are: "+triangle.getside1()+", "+triangle.getside2()+", "+triangle.getside3()+"");
		
		// Calls the perimeter() method of the Triangle class to generate the perimeter using the inputs that the user has provided
		System.out.println("The Triangle perimeter: " +  triangle.perimeter());
		
		// Calls the area() method of the Triangle class to generate the area using the inputs that the user has provided
		System.out.println("The Triangle area: " + triangle.area());
		
		scan.close(); // Closes the scanner object to avoid resource leaks

	}

}
