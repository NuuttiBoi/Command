package org.example.command.commands;

import org.example.command.Cursor;

public class MoveCursorDownCommand implements Command{
  private Cursor cursor;
  public MoveCursorDownCommand(Cursor cursor){
    this.cursor = cursor;
  }
  @Override
  public void execute() {
    cursor.moveDown();
  }
}
