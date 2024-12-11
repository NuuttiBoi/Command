package org.example.command.commands;

import org.example.command.GridModel;

public class GenerateCodeCommand implements Command{
  private GridModel pixelGrid;

  public GenerateCodeCommand(GridModel pixelGrid){
    this.pixelGrid = pixelGrid;
  }
  @Override
  public void execute() {
    StringBuilder code = new StringBuilder("int[][] pixelArt = {\n");
    for (int[] row : pixelGrid.getGrid()) {
      code.append("    {");
      for (int cell : row) {
        code.append(cell).append(", ");
      }
      code.setLength(code.length() - 2); // Remove trailing comma
      code.append("},\n");
    }
    code.setLength(code.length() - 2); // Remove trailing comma
    code.append("\n};");
    System.out.println(code);
  }
}
