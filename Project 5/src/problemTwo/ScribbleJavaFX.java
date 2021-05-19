package problemTwo;
//*********************************************
// Karthik Malyala
//
// A JavaFX application that allows the user to draw or scribble on the scene by dragging the mouse. The application includes
// a color picker as well as a clear button to clear the screen. It utilizes polylines to generate the scribble the user wants to
// draw. This program uses mouse events to process when a user utilizes the mouse to scribble.
//
//*********************************************

// The JavaFX libraries needed for this specific application
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.scene.shape.Polyline;

public class ScribbleJavaFX extends Application{
	private Button clrButton;
	private ColorPicker colorPicker;
	private Polyline polyline[];
	private Polyline currentLine = null;
	private int countPolylines = 0;
	private HBox buttonPicker;
	private Group window, drawingSpace;
	
	// Start method
	public void start (Stage primaryStage) {
		// Clear Button
		clrButton = new Button("Clear");
		clrButton.setOnAction(this::processClrScreen); // Calls the clear method to process clear screen
		//  Color Picker that allows the user to select a color from a palette or other model
		colorPicker = new ColorPicker(Color.BLACK);
		// Array of Polylines to store the scribble inputs from the user
		polyline = new Polyline[1000];
		
		window = new Group();
		drawingSpace = new Group();
		// drawingSpace is a subgroup of window that helps when clearing just the drawing
		window.getChildren().add(drawingSpace);
		
		// Organizing the options in a HBox for clear organization 
		buttonPicker = new HBox(colorPicker, clrButton);
		buttonPicker.setAlignment(Pos.TOP_LEFT);
		buttonPicker.setSpacing(5);
		// Adds the HBox to the window group along with the drawingSpace
		window.getChildren().add(buttonPicker);
		
		// Sets the scene and stage
		Scene scene = new Scene(window, 500, 500);
		primaryStage.setScene(scene);
        primaryStage.setTitle("Scribble");
        primaryStage.show();
        
        // Calls the mouse events methods
        scene.setOnMousePressed(this::processMousePress);
        scene.setOnMouseDragged(this::processMouseDrag);
        scene.setOnMouseReleased(this::processMouseRelease);
	}
	
	// Adds the current polyline to the drawingSpace subgroup using the desired color 
	public void processMousePress (MouseEvent event) {
		currentLine = new Polyline(event.getX(), event.getY());
		currentLine.setStroke(colorPicker.getValue());
		drawingSpace.getChildren().add(currentLine);
	}
	
	// Updates the end point of the current line as the mouse is
	// dragged, creating the rubber band effect
	public void processMouseDrag (MouseEvent event) {
		if (currentLine != null) {
			currentLine.getPoints().addAll(event.getX(), event.getY());
		}
	}
	
	// Once the mouse button is released, the drawing of one polyline ends
	public void processMouseRelease (MouseEvent event) {
		if (currentLine != null) {
			polyline[countPolylines] = currentLine;
			countPolylines++;
		}
		currentLine = null;
	}
	
	// Clear Screen method that clears the drwaingSpace group and sets the polyline array to null
	public void processClrScreen(ActionEvent event) {
		for (int i = 0; i < countPolylines; i++) {
			drawingSpace.getChildren().clear();
			polyline[i] = null;
		}
		countPolylines = 0;
	}

	/* Launches the JavaFX Application. The following method isn't really required
	 * as Eclipse launches the JavaFX Application automatically. However, it is included
	 * for reference!
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
