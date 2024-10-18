package org.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class BattleshipRoyale extends Application {
    private static final int GRID_SIZE = 5;  // Size of the grid (5x5)
    private static final int CELL_SIZE = 100;  // Size of each cell (100x100 pixels)

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();  // Create a GridPane to hold the grid cells

        // Create the grid of rectangles
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                Rectangle cell = createGridCell();
                grid.add(cell, col, row);  // Add the cell to the grid at the specified row and column
            }
        }

        // Create a scene with the grid and set it on the stage
        Scene scene = new Scene(grid, GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Grid Game");
        primaryStage.show();
    }

    // Method to create a grid cell (rectangle)
    private Rectangle createGridCell() {
        Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);
        cell.setFill(Color.LIGHTGRAY);  // Default color for each cell

        // Add an event handler to change the color of the cell when clicked
        cell.setOnMouseClicked(event -> {
            if (cell.getFill().equals(Color.LIGHTGRAY)) {
                cell.setFill(Color.BLUE);  // Change to blue on first click
            } else {
                cell.setFill(Color.LIGHTGRAY);  // Change back to gray on second click
            }
        });

        return cell;
    }

    public static void main(String[] args) {
        launch(args);  // Launch the JavaFX application
    }
}
