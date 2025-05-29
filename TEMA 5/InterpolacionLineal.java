/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interpolacionlineal;

import java.util.Scanner;

/**
 *
 * @author charl
 */
public class InterpolacionLineal {

 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double datoX0, datoY0, datoX1, datoY1, datoX, pendiente, resultado;

        System.out.println("INTERPOLACION LINEAL");
        System.out.print("Ingresa el valor de x0: ");
        datoX0 = sc.nextDouble();
        System.out.print("Ingresa el valor de y0: ");
        datoY0 = sc.nextDouble();
        System.out.print("Ingresa el valor de x1: ");
        datoX1 = sc.nextDouble();
        System.out.print("Ingresa el valor de y1: ");
        datoY1 = sc.nextDouble();
        System.out.print("Ingresa el valor de x a interpolar: ");
        datoX = sc.nextDouble();

        pendiente = (datoY1 - datoY0) / (datoX1 - datoX0);
        resultado = datoY0 + pendiente * (datoX - datoX0);

        System.out.printf("El valor interpolado de y es: %.2f\n", resultado);
    }
}
