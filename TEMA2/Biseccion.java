/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package biseccion;

import java.util.Scanner;
import java.util.function.Function;

/**
 *
 * @author charl
 */
public class Biseccion {

 public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Function<Double, Double> f = x -> Math.cos(x) - x;
        
        System.out.println("Metodo de Biseccion para f(x) = cos(x) - x");
        System.out.print("Ingrese limite inferior del intervalo (a): ");
        double a = scanner.nextDouble();
        
        System.out.print("Ingrese limite superior del intervalo (b): ");
        double b = scanner.nextDouble();
        
        System.out.print("Ingrese tolerancia de error: ");
        double error = scanner.nextDouble();
        
        double fa = f.apply(a);
        double fb = f.apply(b);
        
        if (fa * fb >= 0) {
            System.out.println("No hay raíz en el intervalo o los limites son incorrectos");
            return;
        }
        
        int iteraciones = 0;
        double c = 0;
        
        System.out.println("\nIteracion  a        b        c        f(c)");
        System.out.println("----------------------------------------");
        
        do {
            c = (a + b) / 2;
            double fc = f.apply(c);
            
            System.out.printf("%4d     %6.2f   %6.2f   %6.2f   %8.6f%n", 
                           iteraciones, a, b, c, fc);
            
            if (fc == 0 || (b - a)/2 < error) {
                break;
            }
            
            if (fa * fc < 0) {
                b = c;
                fb = fc;
            } else {
                a = c;
                fa = fc;
            }
            iteraciones++;
            
        } while ((b - a)/2 >= error);
        
        System.out.printf("%nRaiz aproximada: %.2f%n", c);
        System.out.println("Iteraciones: " + iteraciones);
    }
}
