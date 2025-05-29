/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package puntofijo;

import java.util.Scanner;
import java.util.function.Function;

/**
 *
 * @author charl
 */
public class PuntoFijo {

  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Function<Double, Double> g = x -> Math.exp(-x);
        
        System.out.println("Metodo de Punto Fijo para g(x) = e^(-x)");
        System.out.print("Valor inicial (x0): ");
        double x = scanner.nextDouble();
        
        System.out.print("Tolerancia: ");
        double error = scanner.nextDouble();
        
        int iteraciones = 0;
        
        System.out.println("\nIteracion  x        g(x)");
        System.out.println("-----------------------");
        
        while (true) {
            double gx = g.apply(x);
            
            System.out.printf("%4d     %6.2f   %6.2f%n", 
                           iteraciones, x, gx);
            
            if (Math.abs(x - gx) < error) break;
            
            x = gx;
            iteraciones++;
        }
        
        System.out.printf("%nRaiz aproximada: %.2f%n", x);
        System.out.println("Iteraciones: " + iteraciones);
    }
}
