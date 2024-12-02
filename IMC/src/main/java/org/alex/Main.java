package org.tomas;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ignored) {}

        float weight = getInput("Digite seu peso em KG:", 60.00f);
        float height = getInput("Digite sua altura em metros:", 1.50f);

        float bmi = calculateBMI(weight, height);
        String bmiResult = interpretBMI(bmi);

        displayResults(bmi, bmiResult);
    }

    private static float getInput(String message, float defaultValue) {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(message, defaultValue);
                return Float.parseFloat(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Você deve entrar apenas com números");
            }
        }
    }

    private static float calculateBMI(float weight, float height) {
        return weight / (height * height);
    }

    private static String interpretBMI(float bmi) {
        if (bmi <= 18.5) {
            return "Abaixo do Peso";
        } else if (bmi <= 24.9) {
            return "Peso Normal";
        } else if (bmi <= 29.9) {
            return "Acima do Peso";
        } else {
            return "Obeso";
        }
    }

    private static void displayResults(float bmi, String result) {
        DecimalFormat format = new DecimalFormat("#.00");
        String formattedBMI = format.format(bmi);

        String message = "Seu IMC é: " + formattedBMI + "\n"
                + "Resultado final: " + result;

        JOptionPane.showMessageDialog(null, message);
    }
}
