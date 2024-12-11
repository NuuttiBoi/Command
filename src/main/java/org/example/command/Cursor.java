package org.example.command;


public class Cursor {
  private int x = 0;
  private int y = 0;

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void moveUp() {
    if (x > 0) x--;
  }

  public void moveDown() {
    if (x < 7) x++;
  }

  public void moveLeft() {
    if (y > 0) y--;
  }

  public void moveRight() {
    if (y < 7) y++;
  }
}

