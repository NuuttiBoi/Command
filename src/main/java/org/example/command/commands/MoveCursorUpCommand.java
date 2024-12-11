package org.example.command.commands;

import org.example.command.Cursor;

public class MoveCursorUpCommand implements Command{
  private Cursor cursor;
  public MoveCursorUpCommand(Cursor cursor){
    this.cursor = cursor;
  }
  @Override
  public void execute() {
    cursor.moveUp();
  }
}
