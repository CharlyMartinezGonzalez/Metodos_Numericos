/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interpolacionnewton;

/**
 *
 * @author charl
 */
public class InterpolacionNewton {

 public static void main(String[] args) {
        int cantidadDatos = 3;
        double[] valoresX = {0, 1, 3, 6};
        double[] valoresY = {0, 10, 25, 55};
        double[][] tablaDD = new double[4][4];

        for (int i = 1; i <= cantidadDatos; i++) {
            tablaDD[i][1] = valoresY[i];
        }

        for (int j = 2; j <= cantidadDatos; j++) {
            for (int i = 1; i <= cantidadDatos - j + 1; i++) {
                tablaDD[i][j] = (tablaDD[i + 1][j - 1] - tablaDD[i][j - 1]) /
                                (valoresX[i + j - 1] - valoresX[i]);
            }
        }

        double puntoBuscado = 4;
        double resultadoFinal = tablaDD[1][1];
        double acumulador = 1;

        for (int i = 2; i <= cantidadDatos; i++) {
            acumulador *= (puntoBuscado - valoresX[i - 1]);
            resultadoFinal += tablaDD[1][i] * acumulador;
        }

        System.out.printf("El valor interpolado en x = %.0f es: %.2f\n", puntoBuscado, resultadoFinal);
    }
}
