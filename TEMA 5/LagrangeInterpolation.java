/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lagrangeinterpolation;

import java.util.Scanner;

/**
 *
 * @author charl
 */
public class LagrangeInterpolation {

  public static double interpolate(double[] x, double[] y, double xVal) {
        double result = 0.0;
        for (int i = 0; i < x.length; i++) {
            double term = y[i];
            for (int j = 0; j < x.length; j++) {
                if (j != i) {
                    term *= (xVal - x[j]) / (x[i] - x[j]);
                }
            }
            result += term;
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
        System.out.printf("Interpolacion Lagrange en x=%.2f: %.4f\n", xVal, result);

        scanner.close();
    }
}
