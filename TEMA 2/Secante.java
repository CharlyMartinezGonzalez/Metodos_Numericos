/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package secante;

import java.util.Scanner;
import java.util.function.Function;

/**
 *
 * @author charl
 */
public class Secante {

  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Function<Double, Double> f = x -> Math.pow(x, 3) - 2 * x - 5;
        
        System.out.println("Metodo de la Secante para f(x) = x3 - 2x - 5");
        System.out.print("Primer valor (x0): ");
        double x0 = scanner.nextDouble();
        
        System.out.print("Segundo valor (x1): ");
        double x1 = scanner.nextDouble();
        
        System.out.print("Tolerancia: ");
        double error = scanner.nextDouble();
        
        int iteraciones = 0;
        
        System.out.println("\nIteracion  x        f(x)");
        System.out.println("-----------------------");
        
        while (true) {
            double fx0 = f.apply(x0);
            double fx1 = f.apply(x1);
            
            System.out.printf("%4d     %6.2f   %6.2f%n", 
                           iteraciones, x1, fx1);
            
            if (Math.abs(fx1) < error) break;
            if (Math.abs(fx1 - fx0) < 1e-10) {
                System.out.println("Error: diferencia muy pequena");
                return;
            }
            
            double x2 = x1 - fx1 * (x1 - x0) / (fx1 - fx0);
            x0 = x1;
            x1 = x2;
            iteraciones++;
        }
        
        System.out.printf("%nRaiz aproximada: %.2f%n", x1);
        System.out.println("Iteraciones: " + iteraciones);
    }
}
