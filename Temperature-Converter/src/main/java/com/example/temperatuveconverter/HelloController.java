package com.example.temperatuveconverter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class HelloController implements Initializable {
    @FXML
    private ComboBox<String> units;
    @FXML
    private TextField value;
    @FXML
    private Label error;
    @FXML
    private Label temp1;
    @FXML
    private Label temp2;

    private final String[] temps = {"Celsius", "Kelvin", "Fahrenheit"};

    @FXML
    void convert(ActionEvent e) {
        String enteredValue = value.getText();
        double numericValue;
        try{
            numericValue = Double.parseDouble(enteredValue);
        }catch (NumberFormatException nfe){
            error.setText("Enter a temperature value");
            return;
        }
        if (units.getValue() == null) {
            error.setText("Choose a temperature unit");
        }else{
            error.setText("");
            String unit = units.getValue();
            Converter converter = new Converter(unit, numericValue);
            if (unit.equals("Kelvin")) {
                temp1.setText("Celsius: " + converter.convertToCelsius());
                temp2.setText("Fahrenheit: " + converter.convertToFahrenheit());
            } else if (unit.equals("Celsius")) {
                temp1.setText("Kelvin: " + converter.convertToKelvin());
                temp2.setText("Fahrenheit: " + converter.convertToFahrenheit());
            } else {
                temp1.setText("Kelvin: " + converter.convertToKelvin());
                temp2.setText("Celsius: " + converter.convertToCelsius());
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        units.getItems().addAll(temps);
        error.setStyle("-fx-alignment: center;");

        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("-?\\d*(\\.\\d*)?")) {
                return change;
            }
            return null;
        };
        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        value.setTextFormatter(textFormatter);
    }
}