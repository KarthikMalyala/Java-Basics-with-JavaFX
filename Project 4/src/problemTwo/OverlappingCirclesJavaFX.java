package problemTwo;
//*********************************************
// Karthik Malyala
//
// A JavaFX application that display 40 circles with each radius being random within a range of 1-30 pixels. None of the circles
// cross the boundaries of the window. If a circle does overlap over another circle, the fill color of that circle as well as the one
// it overlaps will be changed to semi-transparent blue so we can see all the circles within the overlap. Let it be known that two circles
// overlap if the distance between their centers is less than the sum of their radii.
//
//*********************************************

// Libraries needed to set the scene and stage for the JavaFX program. This also includes the Random and Math libraries to perform 
// randomization and calculations
import java.util.Random; 
import java.lang.Math; 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class OverlappingCirclesJavaFX extends Application{
	// Start Method
	public void start(Stage primaryStage) {
		
		Random random = new Random(); // Creates a random object to generate the random radius
		// Constants for window height and width
		final int sceneWidth = 400; 
		final int sceneHeight = 400;
		
		// Sets up the circle array of 40 circles as per the prompt
		Circle circleArray[] = new Circle[40];
		
		// Loops for 40 times that sets up every circle at a random location, radius, and respective color fill
		for (int i = 0; i < circleArray.length; i++) {
			int radius;
			radius = random.nextInt(30) + 1; // Generates a random radius in the range 1-30
			
			// Generates a random center x and y for the circle, making sure the circle won't go out of the window
			int centerX = random.nextInt(sceneWidth - (2*radius)) + radius; 
			int centerY = random.nextInt(sceneHeight - (2*radius)) + radius;
			
			// Creates the circle object that utilizes all the generated values above
			Circle circle = new Circle();
			circle.setCenterX(centerX);
			circle.setCenterY(centerY);
			circle.setRadius(radius);
			
			circleArray[i] = circle; // First entry into the circle array
			
			circleArray[i].setFill(new Color (0.0, 0.0, 1.0, 1.0)); // Default color. If overlap, the nested for-loop will take care
			
			boolean overlap = false; // Boolean to test if the circles overlap
			for (int j = 0; j < i; j++) {
				if (i == j) { // If the i and j values are equal, the loop breaks because it is the same circle and can resort to default color
					break;
				}
				
				// Gets the center x, y, and radius of a previous circle
				double testX = circleArray[j].getCenterX();
				double testY = circleArray[j].getCenterY();
				double testR = circleArray[j].getRadius();
				
				// Differences of the centers
				double diffX = testX - centerX;
				double diffY = testY - centerY;
				
				// Calculating the distance using the distance formula
				double centerDistance = Math.sqrt((diffX * diffX) + (diffY *diffY));
				
				// If-else loop for overlap test and gradient color assignment
				if (centerDistance <= (radius + testR)) {
					Color overlapGradient = new Color (0.0, 0.0, 1.0, 0.3); // If overlap, the fill will be a gradient blue
					circleArray[i].setFill(overlapGradient);
					overlap = true; // Sets the boolean to true
					circleArray[j].setFill(overlapGradient); // Fills both circle with a gradient so we can see both of them overlap
				}
				// If the two circles don't overlap when compared, then the circle is filled with complete opaque blue
				else if (!overlap) {
					Color completeBlueFill = new Color (0, 0, 1.0, 1.0);
					circleArray[i].setFill(completeBlueFill); // Fills the circle being compared to opaque blue
				}
				
			}
		}
	
		Pane root = new Pane();
		root.getChildren().addAll(circleArray); // Adds all the circles in the array to the root pane
		
		// Sets the scene using the circle array as the root node and the window width and height constants
		Scene scene = new Scene(root, sceneWidth, sceneHeight);
		primaryStage.setTitle("Overlapping Circles"); // Sets the title of the stage
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/* Launches the JavaFX Application. The following method isn't really required
	 * as Eclipse launches the JavaFX Application automatically. However, it is included
	 * for reference!
	 */
	public static void main(String[] args) {
		launch(args);
	}


}
