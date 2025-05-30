/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reglafalsa;

import java.util.Scanner;
import java.util.function.Function;

/**
 *
 * @author charl
 */
public class ReglaFalsa {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Function<Double, Double> f = x -> Math.log(x) + x;
        
        System.out.println("Metodo de la Regla Falsa para f(x) = ln(x) + x");
        System.out.print("Ingrese limite inferior (a): ");
        double a = scanner.nextDouble();
        
        System.out.print("Ingrese limite superior (b): ");
        double b = scanner.nextDouble();
        
        System.out.print("Ingrese tolerancia: ");
        double error = scanner.nextDouble();
        
        double fa = f.apply(a);
        double fb = f.apply(b);
        
        if (fa * fb >= 0) {
            System.out.println("No hay raiz en el intervalo");
            return;
        }
        
        int iteraciones = 0;
        double c = 0;
        double fc = 0;
        
        System.out.println("\nIteracion  a        b        c        f(c)");
        System.out.println("----------------------------------------");
        
        do {
            c = (a * fb - b * fa) / (fb - fa);
            fc = f.apply(c);
            
            System.out.printf("%4d     %6.2f   %6.2f   %6.2f   %8.6f%n", 
                           iteraciones, a, b, c, fc);
            
            // Condición de terminación corregida
            if (Math.abs(fc) < error) break;
            
            if (fa * fc < 0) {
                b = c;
                fb = fc;
            } else {
                a = c;
                fa = fc;
            }
            iteraciones++;
            
        } while (true);
        
        System.out.printf("%nRaiz aproximada: %.2f%n", c);
        System.out.println("Iteraciones: " + iteraciones);
    }
}
