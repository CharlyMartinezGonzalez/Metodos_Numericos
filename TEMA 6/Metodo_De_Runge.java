/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metodo_de_runge;

/**
 *
 * @author charl
 */
public class Metodo_De_Runge {

  public static double f(double x, double y) { 
        return y;  // dy/dx = y 
    } 
    public static void rungeKutta(double x0, double y0, double xf, double h) 
{ 
        double x = x0; 
        double y = y0; 
 
        while (x < xf + 1e-6) { 
            double k1 = h * f(x, y); 
            double k2 = h * f(x + h / 2.0, y + k1 / 2.0); 
            double k3 = h * f(x + h / 2.0, y + k2 / 2.0); 
            double k4 = h * f(x + h, y + k3); 
 
            y += (k1 + 2*k2 + 2*k3 + k4) / 6.0; 
            x += h; 
 
            System.out.printf("%.2f \t%.6f%n", x, y); 
        } 
    } 
 
    public static void main(String[] args) { 
        System.out.println("Ejercicio 1 - Crecimiento exponencial"); 
        System.out.println("x \ty"); 
        rungeKutta(0, 1, 1, 0.2); 
    } 
}
