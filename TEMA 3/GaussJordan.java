/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gaussjordan;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author charl
 */
public class GaussJordan {
  public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
    DecimalFormat df = new DecimalFormat("#.####"); 
    double[][] matrix = { 
        {2, -1, 1, 3}, 
        {1, 3, 2, 12}, 
        {1, -1, 2, 0} 
    }; 
 
    System.out.println("Resolviendo el Ejercicio 2:"); 
    gaussJordan(matrix, 3, df); 
 
    sc.close(); 
    } 
    public static void gaussJordan(double[][] matrix, int n, DecimalFormat df) { 
        for (int i = 0; i < n; i++) { 
            double pivot = matrix[i][i]; 
             
            if (pivot == 0) { 
                System.out.println("No se puede resolver: hay un pivote cero."); 
                return; 
            } 
            System.out.println("Dividiendo fila " + (i + 1) + " por "+ df.format(pivot)); 
            for (int j = 0; j < n + 1; j++) { 
                matrix[i][j] /= pivot; 
            } 
            printMatrix(matrix, n, df); 
 
            for (int k = 0; k < n; k++) { 
                if (k != i) { 
                    double factor = matrix[k][i]; 
                    System.out.println("Eliminando elemento en " + (k + 1) + ", columna " + (i + 1)); 
 
                    for (int j = 0; j < n + 1; j++) { 
 
                        matrix[k][j] -= factor * matrix[i][j]; 
                    } 
                    printMatrix(matrix, n, df); 
                } 
            } 
        } 
        System.out.println("Solución del sistema:"); 
        for (int i = 0; i < n; i++) { 
            System.out.println("x" + (i + 1) + " = " + df.format(matrix[i][n])); 
        } 
    } 
 
    public static void printMatrix(double[][] matrix, int n, DecimalFormat df) { 
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < n + 1; j++) { 
                System.out.print(df.format(matrix[i][j]) + "\t"); 
            } 
            System.out.println(); 
        } 
    } 

}
