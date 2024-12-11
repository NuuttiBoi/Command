package org.example.command;


import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import org.example.command.commands.*;


public class PixelArtView {
  private static final int CELL_SIZE = 40;

  private final GridModel gridModel = new GridModel();
  private final Cursor cursor = new Cursor();

  private Rectangle[][] cells;

  public VBox createView() {
    VBox root = new VBox();
    GridPane grid = createGrid();

    Button generateCodeButton = new Button("Generate Code");
    generateCodeButton.setOnMouseClicked(e -> {
      Command generateCodeCommand = new GenerateCodeCommand(gridModel);
      generateCodeCommand.execute();
    });

    root.getChildren().addAll(grid, generateCodeButton);
    return root;
  }

  private GridPane createGrid() {
    GridPane gridPane = new GridPane();
    cells = new Rectangle[8][8];
    gridPane.setOnKeyPressed(this::handleKeyPress);

    for (int x = 0; x < 8; x++) {
      for (int y = 0; y < 8; y++) {
        Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);
        cell.setFocusTraversable(true);
        cell.setStyle("-fx-stroke: black; -fx-fill: white;");
        gridPane.add(cell, y, x);
        cells[x][y] = cell;
      }
    }
    return gridPane;
  }

  public void updateGrid() {
    for (int x = 0; x < 8; x++) {
      for (int y = 0; y < 8; y++) {
        cells[x][y].setStyle(gridModel.getGrid()[x][y] == 1
                ? "-fx-fill: black;"
                : "-fx-fill: white;");
      }
    }
    cells[cursor.getX()][cursor.getY()].setStyle("-fx-fill: red;");
  }

  public void handleKeyPress(KeyEvent event) {
    Command command = switch (event.getCode()) {
      case UP -> new MoveCursorUpCommand(cursor);
      case DOWN -> new MoveCursorDownCommand(cursor);
      case LEFT -> new MoveCursorLeftCommand(cursor);
      case RIGHT -> new MoveCursorRightCommand(cursor);
      case SPACE -> new TogglePixelCommand(gridModel, cursor);
      default -> null;
    };
    if (command != null) {
      command.execute();
      updateGrid();
    }
  }
}
