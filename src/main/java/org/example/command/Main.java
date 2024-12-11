package org.example.command;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
  @Override
  public void start(Stage primaryStage) {
    PixelArtView view = new PixelArtView();
    VBox root = view.createView();

    Scene scene = new Scene(root, 400, 400);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Pixel Art Editor");
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}