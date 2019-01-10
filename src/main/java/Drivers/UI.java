package Drivers;

import Controllers.Finder;
import javafx.application.Application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.net.ProtocolException;

public class UI extends Application {

    Finder finder = new Finder();

    public boolean queryCheck(String s) {
        if (s.length() > 0)
            return true;
        System.out.println("Bad Query.Recheck Again [Query]: " + s);
        return false;
    }


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Robo Dictionary");

        GridPane grid = new GridPane();
        grid.setVgap(6);
        grid.setHgap(10);

        Scene scene = new Scene(new Group(), 650, 400);
        final TextField queryBox = new TextField();
        queryBox.setText("Query");
        queryBox.clear();
        final TextArea definition = new TextArea();
        definition.setMinWidth(50);
        definition.setPrefWidth(400);
        definition.setMaxWidth(400);
        definition.setWrapText(true);
        definition.setText("Answer Will be Displayed Here");
        definition.prefColumnCountProperty().bind(definition.textProperty().length());
        definition.setWrapText(true);
        definition.setEditable(false);
        definition.clear();


        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new Label("Insert Query Word Here"), 0, 0);
        grid.add(queryBox, 1, 0);
        grid.add(new Label("Details:"), 1, 2);
        grid.add(definition, 1, 3);


        Group root = (Group) scene.getRoot();
        root.getChildren().add(grid);
        root.prefWidth(500);
        root.prefHeight(500);
        /**
         * Button Search
         */
        final Button search = new Button("Search");
        grid.add(search, 1, 2);
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });

        search.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                definition.setText("Searching.....");
                String query = queryBox.getText();
                if (!queryCheck(query))
                    definition.setText("Bad Query. Please DoubleCheck.\nError Causing Query: " + query);
                else
                    try {
                        definition.setText(finder.uiPresenter(query));
                    } catch (ProtocolException e1) {
                        e1.printStackTrace();
                    }
            }
        });
    }

    public void start() {
        Application.launch();
    }
}


