package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] list = new int[]{2,67,8,893,2,3,2,5,7,};
        SortAlgo sort = new SortAlgo(list);

        System.out.print(Arrays.toString(sort.sort()));

        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le premier nombre : ");
        float input1 = scanner.nextFloat();

        System.out.print("Entrez le second nombre : ");
        float input2 = scanner.nextFloat();

        System.out.print("Entrez l'opérateur (+, -, *, /) : ");
        char operator = scanner.next().charAt(0);

        Calculatrice calc = new Calculatrice(input1, input2, operator);
        try {
            float result = calc.calculate();
            System.out.println("Résultat : " + result);
        } catch (ArithmeticException e) {
            System.out.println("Erreur : " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : Opérateur non reconnu.");
        }
    }
}
