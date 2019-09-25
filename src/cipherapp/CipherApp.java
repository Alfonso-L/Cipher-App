/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cipherapp;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author AL
 */
public class CipherApp extends Application {

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        Pane root = new CipherPane();

        Scene scene = new Scene(root, 700, 850);

        primaryStage.setTitle("Cipher App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
