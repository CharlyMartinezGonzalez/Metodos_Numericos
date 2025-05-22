/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.newtoninterpolation;


import java.util.Scanner;

/**
 *
 * @author charl
 */
public class NewtonInterpolation {

 public static double interpolate(double[] x, double[] y, double xVal) {
        double[] coef = y.clone();
        int n = x.length;

        // Cálculo de diferencias divididas
        for (int j = 1; j < n; j++) {
            for (int i = n - 1; i >= j; i--) {
                coef[i] = (coef[i] - coef[i - 1]) / (x[i] - x[i - j]);
            }
        }

        // Evaluación del polinomio
        double result = coef[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            result = result * (xVal - x[i]) + coef[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el numero de puntos: ");
        int n = scanner.nextInt();

        double[] x = new double[n];
        double[] y = new double[n];

        System.out.println("Ingrese los valores de x:");
        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = scanner.nextDouble();
        }

        System.out.println("Ingrese los valores de y:");
        for (int i = 0; i < n; i++) {
            System.out.print("y[" + i + "]: ");
            y[i] = scanner.nextDouble();
        }

        System.out.print("Ingrese el valor de x a interpolar: ");
        double xVal = scanner.nextDouble();

        double result = interpolate(x, y, xVal);
        System.out.printf("Interpolacion Newton en x=%.2f: %.4f\n", xVal, result);
        
        scanner.close();
    }
}
