package io.github.faizansaghir.designPatterns.mediator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MediatorPatternApplication extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        UIMediator mediator = new UIMediator();
        Slider slider = new Slider(mediator);
        Label label = new Label(mediator);
        TextBox textBox = new TextBox(mediator);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(20);
        grid.setPadding(new Insets(25,25,25,25));
        grid.add(label, 0, 0);
        grid.add(slider, 0, 1);
        grid.add(textBox, 0, 2);
        Scene scene = new Scene(grid, 500, 500);
        stage.setTitle("Mediator Pattern");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
