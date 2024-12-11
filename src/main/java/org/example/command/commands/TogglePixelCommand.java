package org.example.command.commands;

import org.example.command.Cursor;
import org.example.command.GridModel;

public class TogglePixelCommand implements Command {
  private final GridModel gridModel;
  private final Cursor cursor;

  public TogglePixelCommand(GridModel gridModel, Cursor cursor) {
    this.gridModel = gridModel;
    this.cursor = cursor;
  }

  @Override
  public void execute() {
    gridModel.togglePixel(cursor.getX(), cursor.getY());
  }
}