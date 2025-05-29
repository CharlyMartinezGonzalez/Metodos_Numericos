/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minimoscuadrados;

import java.util.Scanner;

/**
 *
 * @author charl
 */
public class MinimosCuadrados {

  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuantos pares de datos vas a ingresar? ");
        int cantidad = sc.nextInt();

        double[] listaX = new double[cantidad];
        double[] listaY = new double[cantidad];

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese x[" + (i + 1) + "]: ");
            listaX[i] = sc.nextDouble();
            System.out.print("Ingrese y[" + (i + 1) + "]: ");
            listaY[i] = sc.nextDouble();
        }

        double sumaX = 0, sumaY = 0, sumaX2 = 0, sumaXY = 0;

        for (int i = 0; i < cantidad; i++) {
            sumaX += listaX[i];
            sumaY += listaY[i];
            sumaX2 += Math.pow(listaX[i], 2);
            sumaXY += listaX[i] * listaY[i];
        }

        double pendiente = (cantidad * sumaXY - sumaX * sumaY) / (cantidad * sumaX2 - Math.pow(sumaX, 2));
        double intercepto = (sumaY - pendiente * sumaX) / cantidad;

        System.out.printf("La recta de regresion es: y = %.2f + %.2fx\n", intercepto, pendiente);
    }
}
