package com.example.temperatuveconverter;

import java.text.DecimalFormat;

public class Converter {
    private String unit;
    private double value;
    private double result;
    private DecimalFormat decimalFormat = new DecimalFormat("#.####");

    public Converter(String unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    public String convertToKelvin() {
        if (unit.equals("Fahrenheit")) {
            result = (value + 459.67) / 1.8;
        } else {
            result = value + 273.15;
        }
        return decimalFormat.format(result);
    }

    public String convertToCelsius() {
        if (unit.equals("Fahrenheit")) {
            result = (value - 32)/1.8;
        } else {
            result = value - 273.15;
        }
        return decimalFormat.format(result);
    }

    public String convertToFahrenheit() {
        if (unit.equals("Kelvin")) {
            result = value * 1.8 - 459.67;
        } else {
            result = value * 1.8 + 32;
        }
        return decimalFormat.format(result);
    }
}
