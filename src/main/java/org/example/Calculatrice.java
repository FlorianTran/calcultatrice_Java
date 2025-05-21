package org.example;

public class Calculatrice {
    private float input_1;
    private float input_2;
    private char operator;

    public Calculatrice(float input_1, float input_2, char operator) {
        this.input_1 = input_1;
        this.input_2 = input_2;
        this.operator = operator;
    }

    public float calculate() {
        switch (operator) {
            case '+':
                return add(input_1, input_2);
            case '-':
                return substract(input_1, input_2);
            case '*':
                return multiplication(input_1, input_2);
            case '/':
                return division(input_1, input_2);
            default:
                throw new IllegalArgumentException("Opérateur non supporté : " + operator);
        }
    }

    public static boolean isEquals(float input_1, float input_2) {
        return Math.abs(input_1 - input_2) < 0.0001f;
    }

    public static float add(float input_1, float input_2) {
        return input_1 + input_2;
    }

    public static float substract(float input_1, float input_2) {
        return input_1 - input_2;
    }

    public static float division(float input_1, float input_2) {
        if (input_2 == 0) throw new ArithmeticException("Division par 0");
        return input_1 / input_2;
    }

    public static float multiplication(float input_1, float input_2) {
        return input_1 * input_2;
    }
}
