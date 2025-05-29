/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metododeeuler;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 * @author charl
 */
public class MetodoDeEuler {

    public static double f(double x, double y) { 
        return x + y; 
    } 
 
    public static void metodoEuler(double x0, double y0, double h, int n) { 
        double x = x0, y = y0; 
        DecimalFormat df = new DecimalFormat("#.##"); 
        df.setRoundingMode(RoundingMode.HALF_UP); // Redondeo hacia el más cercano
        System.out.println("x\t\ty"); 
        for (int i = 0; i <= n; i++) { 
            System.out.println(df.format(x) + "\t\t" + df.format(y)); 
            y = y + h * f(x, y); 
            x = x + h; 
        } 
    } 
 
    public static void main(String[] args) { 
        metodoEuler(0, 1, 0.1, 10); 
    }
    
}
