/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metodotrapecio;

import java.util.Scanner;

/**
 *
 * @author charl
 */
public class MetodoTrapecio {

    public static double f(double x) { 
        return Math.log(x); 
    } 
    public static double integrarTrapecio(double a, double b, int n) { 
        double h = (b - a) / n; 
        double suma = (f(a) + f(b)) / 2.0; 
 
        for (int i = 1; i < n; i++) { 
            double xi = a + i * h; 
            suma += f(xi); 
        } 
        return h * suma; 
    } 
    public static void main(String[] args) { 
         Scanner scanner = new Scanner(System.in); 
        System.out.println("Metodo del Trapecio - Metodos Numericos"); 
        System.out.print("Ingresa el limite inferior: "); 
        double a = scanner.nextDouble(); 
        System.out.print("Ingresa el limite superior: "); 
        double b = scanner.nextDouble(); 
        System.out.print("Ingresa el numero de subintervalos n: "); 
        int n = scanner.nextInt(); 
        double resultado = integrarTrapecio(a, b, n); 
        System.out.printf("La aproximacion de la integral es: %.4f%n", 
resultado); 
        double resultadoExacto = 2 * Math.log(2) - 1; 
        System.out.printf("Resultado exacto (estimado): 2 * ln(2) - 1 ≈ %.4f%n", resultadoExacto); 
    }
    
}
