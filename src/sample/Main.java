package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    Pane root;
    GridPane pane;
    TextArea txfInput, txfOutput;
    Button btnExport, btnImport;

    @Override
    public void start(Stage primaryStage) throws Exception{
        root = new Pane();
        pane = new GridPane();
        pane.setVgap(5);
        pane.setHgap(5);
        pane.setPadding(new Insets(5));
        txfInput = new TextArea();
        txfInput.setPromptText("Input");
        txfOutput = new TextArea();
        txfOutput.setPromptText("Output");
        btnExport = new Button("Export");
        btnImport = new Button("Import");
        pane.add(txfInput, 0, 0, 2, 1);
        pane.add(txfOutput, 0, 1, 2, 1);
        pane.add(btnExport, 0, 2);
        pane.add(btnImport, 1, 2);
        root.getChildren().add(pane);
        primaryStage.setTitle("Prime Encryption");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
