package com.core;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    Pane root;
    GridPane pane;
    TextArea txfInput, txfOutput;
    Button btnExport, btnImport;
    RadioButton rdEncrypt, rdDecrypt;
    final ToggleGroup group = new ToggleGroup();

    Encrypter en;

    @Override
    public void start(Stage primaryStage) throws Exception{
        en = new Encrypter();

        root = new Pane();
        pane = new GridPane();
        pane.setVgap(5);
        pane.setHgap(5);
        pane.setPadding(new Insets(5));
        txfInput = new TextArea();
        txfInput.setPromptText("Input");
        txfOutput = new TextArea();
        txfOutput.setPromptText("Output");
        rdEncrypt = new RadioButton("Encrypt");
        rdEncrypt.fire();
        rdDecrypt = new RadioButton("Decrypt");
        rdEncrypt.setToggleGroup(group);
        rdDecrypt.setToggleGroup(group);
        btnExport = new Button("Export");
        btnImport = new Button("Import");

        //TODO: Update Text before Encryption
        txfInput.setOnKeyTyped(
            e -> {
                if(group.getSelectedToggle() == rdEncrypt){
                    txfOutput.setText(en.encryptText(txfInput.getText()));
                }else if(group.getSelectedToggle() == rdDecrypt){
                    txfOutput.setText(en.decryptText(txfInput.getText()));
                }
            }
        );
        pane.add(txfInput, 0, 0, 2, 2);
        pane.add(rdEncrypt, 2, 0);
        pane.add(rdDecrypt, 2, 1);
        pane.add(txfOutput, 0, 2, 2, 2);
        pane.add(btnExport, 0, 4);
        pane.add(btnImport, 1, 4);
        root.getChildren().add(pane);
        primaryStage.setTitle("Prime Encryption");
        primaryStage.setScene(new Scene(root, 575, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
