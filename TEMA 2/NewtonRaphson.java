/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package newtonraphson;

import java.util.Scanner;
import java.util.function.Function;

/**
 *
 * @author charl
 */
public class NewtonRaphson {

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Function<Double, Double> f = x -> Math.pow(x, 2) - Math.sin(x);
        Function<Double, Double> df = x -> 2 * x - Math.cos(x);
        
        System.out.println("Metodo de Newton-Raphson para f(x) = x² - sen(x)");
        System.out.print("Valor inicial (x0): ");
        double x = scanner.nextDouble();
        
        System.out.print("Tolerancia: ");
        double error = scanner.nextDouble();
        
        int iteraciones = 0;
        
        System.out.println("\nIteracion  x        f(x)     f'(x)");
        System.out.println("---------------------------------");
        
        while (true) {
            double fx = f.apply(x);
            double dfx = df.apply(x);
            
            System.out.printf("%4d     %6.2f   %6.2f   %6.2f%n", 
                           iteraciones, x, fx, dfx);
            
            if (Math.abs(fx) < error) break;
            if (dfx == 0) {
                System.out.println("Error: derivada cero");
                return;
            }
            
            x = x - fx / dfx;
            iteraciones++;
        }
        
        System.out.printf("%nRaiz aproximada: %.2f%n", x);
        System.out.println("Iteraciones: " + iteraciones);
    }
}
