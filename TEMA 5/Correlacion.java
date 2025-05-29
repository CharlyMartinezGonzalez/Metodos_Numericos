/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package correlacion;

import java.util.Scanner;

/**
 *
 * @author charl
 */
public class Correlacion {

   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el numero de datos: ");
        int n = sc.nextInt();

        double[] datosX = new double[n];
        double[] datosY = new double[n];

        double sumaX = 0, sumaY = 0, sumaXY = 0, sumaX2 = 0, sumaY2 = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese X[" + (i + 1) + "]: ");
            datosX[i] = sc.nextDouble();
            System.out.print("Ingrese Y[" + (i + 1) + "]: ");
            datosY[i] = sc.nextDouble();

            sumaX += datosX[i];
            sumaY += datosY[i];
            sumaXY += datosX[i] * datosY[i];
            sumaX2 += Math.pow(datosX[i], 2);
            sumaY2 += Math.pow(datosY[i], 2);
        }

        double coefPendiente = (n * sumaXY - sumaX * sumaY) / (n * sumaX2 - Math.pow(sumaX, 2));
        double coefIntercepto = (sumaY - coefPendiente * sumaX) / n;
        double r = (n * sumaXY - sumaX * sumaY) /
                   Math.sqrt((n * sumaX2 - Math.pow(sumaX, 2)) * (n * sumaY2 - Math.pow(sumaY, 2)));

        System.out.printf("Ecuacion de regresion: Y = %.2f + %.2fX\n", coefIntercepto, coefPendiente);
        System.out.printf("Coeficiente de correlacion r = %.4f\n", r);
    }
}
