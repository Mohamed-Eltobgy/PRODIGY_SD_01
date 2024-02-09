package com.example.temperatuveconverter;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class HelloController implements Initializable {
    @FXML
    private ComboBox<String> units;
    @FXML
    private TextField value;
    private final String[] temps = {"Celsius", "Kelvin", "Fahrenheit"};
    private String unit;

    @FXML
    void getUnit(ActionEvent e) {
        unit = units.getValue();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        units.getItems().addAll(temps);

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