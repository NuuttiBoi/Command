package org.example.command;
public class GridModel {
  private final int[][] grid;

  public GridModel() {
    grid = new int[8][8];
  }

  public int[][] getGrid() {
    return grid;
  }

  public void togglePixel(int x, int y) {
    grid[x][y] = grid[x][y] == 0 ? 1 : 0;
  }

}
