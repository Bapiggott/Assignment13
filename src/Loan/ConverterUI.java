package Loan;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ConverterUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Label inputLabel = new Label("Input:");
        grid.add(inputLabel, 0, 0);

        TextField inputField = new TextField();
        grid.add(inputField, 1, 0);

        Label resultLabel = new Label("Result:");
        grid.add(resultLabel, 0, 1);

        TextField resultField = new TextField();
        resultField.setEditable(false);
        grid.add(resultField, 1, 1);

        Button convertButton = new Button("Convert");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(convertButton);
        grid.add(hbBtn, 1, 2);

        convertButton.setOnAction((event) -> {
            String input = inputField.getText();

            if (input.equals("exit") || input.equals("-1")) {
                primaryStage.close();
            }

            String[] parts = input.split(" ");
            if (parts.length != 4) {
                resultField.setText("Your input is not currently handled by this app, please input another query, for example, 1 kg to lb");
                return;
            }

            double value = Double.parseDouble(parts[0]);
            String from = parts[1];
            String to = parts[3];

            double result = 0;
            switch (from + "-" + to) {
                case "km-m":
                    result = value * 1000;
                    break;
                case "m-km":
                    result = value / 1000;
                    break;
                case "kg-lb":
                    result = value * 2.20462;
                    break;
                case "lb-kg":
                    result = value / 2.20462;
                    break;
                case "ft-m":
                    result = value * .3048;
                    break;
                case "m-ft":
                    result = value / .3048;
                    break;
                case "mi-km":
                    result = value * 1.609344;
                    break;
                case "km-mi":
                    result = value / 1.609344;
                    break;
                case "mph-kph":
                    result = value * 1.609344;
                    break;
                case "kph-mph":
                    result = value / 1.609344;
                    break;
                default:
                    resultField.setText("Your input is not currently handled by this app, please input another query, for example, 1 kg to lb");
                    return;
            }

            resultField.setText(String.format("%.2f %s = %.2f %s", value, from, result, to));
        });

        Scene scene = new Scene(grid, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Converter");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}