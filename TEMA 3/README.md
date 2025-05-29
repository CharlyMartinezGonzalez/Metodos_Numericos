# Métodos Numéricos para Sistemas de Ecuaciones

## Índice de Métodos
1. [Método de Eliminación Gaussiana](#método-de-eliminación-gaussiana)
2. [Método de Gauss-Jordan](#método-de-gauss-jordan)
3. [Método de Gauss-Seidel](#método-de-gauss-seidel)
4. [Método de Jacobi](#método-de-jacobi)

---

## Método de Eliminación Gaussiana
<a name="método-de-eliminación-gaussiana"></a>

### Pseudocódigo

Proceso EliminacionGaussiana
 
    Para i desde 0 hasta n-1 hacer
        Para j desde 0 hasta n hacer
            Leer A[i][j]
        Fin Para
    Fin Para

    // Eliminación hacia adelante con pivoteo
    Para k desde 0 hasta n-2 hacer
        i_max = k
        v_max = |A[k][k]|
        
        Para i desde k+1 hasta n-1 hacer
            Si |A[i][k]| > v_max entonces
                v_max = |A[i][k]|
                i_max = i
            Fin Si
        Fin Para
        
        Si A[i_max][k] = 0 entonces
            Imprimir "Matriz singular"
            Detener
        Fin Si
        
        Si i_max ≠ k entonces
            Intercambiar fila k con fila i_max
        Fin Si
        
        Para i desde k+1 hasta n-1 hacer
            factor = A[i][k] / A[k][k]
            Para j desde k hasta n hacer
                A[i][j] = A[i][j] - factor * A[k][j]
            Fin Para
        Fin Para
    Fin Para

    // Sustitución hacia atrás
    X[n-1] = A[n-1][n] / A[n-1][n-1]
    
    Para i desde n-2 hasta 0 hacer
        suma = A[i][n]
        Para j desde i+1 hasta n-1 hacer
            suma = suma - A[i][j] * X[j]
        Fin Para
        X[i] = suma / A[i][i]
    Fin Para

    // Mostrar resultados
    Para i desde 0 hasta n-1 hacer
        Imprimir "X[", i, "] = ", X[i]
    Fin Para

Fin Proceso

### Caso de prueba

Dado el siguiente sistema de ecucaciones determinar el valor de las variables: X1, x2, x3 <br>

2x + 3y - z = 5<br>
4x + 2y + 3z = 12<br>
3x - y + 2z = 6<br>

### Matriz aumentada
[2, 3, -1, 5]<br>
[4, 2, 3, 12]<br>
[3, -1, 2, 6]<br>

### Resultado
x ≈ 1.519<br>
y ≈ 1.074<br>
z ≈ 1.259<br>

---

## Método de Gauss-Jordan
<a name="método-de-gauss-jordan"></a>

### Pseudocódigo

Proceso GaussJordan
    // Ingresar matriz aumentada
    Para i desde 0 hasta n-1 hacer
        Para j desde 0 hasta n hacer
            Leer A[i][j]
        Fin Para
    Fin Para

    // Reducción a forma escalonada reducida
    Para i desde 0 hasta n-1 hacer
        // Pivoteo
        Si A[i][i] = 0 entonces
            Encontrar fila k > i con A[k][i] ≠ 0
            Intercambiar fila i con fila k
        Fin Si
        
        // Hacer pivote = 1
        pivote = A[i][i]
        Para j desde i hasta n hacer
            A[i][j] = A[i][j] / pivote
        Fin Para
        
        // Hacer ceros en otras filas
        Para k desde 0 hasta n-1 hacer
            Si k ≠ i entonces
                factor = A[k][i]
                Para j desde i hasta n hacer
                    A[k][j] = A[k][j] - factor * A[i][j]
                Fin Para
            Fin Si
        Fin Para
    Fin Para

    // Mostrar solución
    Para i desde 0 hasta n-1 hacer
        Imprimir "x", i+1, " = ", A[i][n]
    Fin Para
Fin Proceso

### Caso de prueba

Dado el siguiente sistema de ecucaciones determinar el valor de las variables: X1, x2, x3 <br>

2x - y + z = 3<br>
x + 3y + 2z = 12<br>
x - y + 2z = 0<br>

### Matriz aumentada
[2, -1, 1, 3]<br>
[1, 3, 2, 12]<br>
[1, -1, 2, 0]<br>

### Resultado
x = 3<br>
y = 3<br>
z = 0<br>

---

## Método de Gauss-Seidel
<a name="método-de-gauss-seidel"></a>

### Pseudocódigo

Proceso GaussSeidel

    Para i desde 0 hasta n-1 hacer
        Para j desde 0 hasta n-1 hacer
            Leer A[i][j]
        Fin Para
        Leer b[i]
    Fin Para

    // Inicializar variables
    Definir x[n], xNuevo[n]
    Para i desde 0 hasta n-1 hacer
        x[i] = 0
    Fin Para
    
    iteraciones = 0
    tolerancia = 0.0001
    maxIter = 100
    
    // Iteraciones
    Mientras iteraciones < maxIter hacer
        error = 0
        
        Para i desde 0 hasta n-1 hacer
            suma = 0
            Para j desde 0 hasta n-1 hacer
                Si j ≠ i entonces
                    suma = suma + A[i][j] * x[j]
                Fin Si
            Fin Para
            xNuevo = (b[i] - suma) / A[i][i]
            error = Máx(error, |xNuevo - x[i]|)
            x[i] = xNuevo
        Fin Para
        
        Si error < tolerancia entonces
            Imprimir "Convergencia en ", iteraciones, " iteraciones"
            Terminar
        Fin Si
        
        iteraciones = iteraciones + 1
    Fin Mientras
    
    Imprimir "Solución:"
    Para i desde 0 hasta n-1 hacer
        Imprimir "x", i+1, " = ", x[i]
    Fin Para
Fin Proceso

### Caso de prueba

Dado el siguiente sistema de ecucaciones determinar el valor de las variables: X1, x2, x3 <br>

10x + 2y + z = 9 <br>
3x + 10y + 4z = 24 <br>
2x + 3y + 10z = 18 <br>

### Datos de entrada
A = [[10, 2, 1], [3, 10, 4], [2, 3, 10]]<br>
b = [9, 24, 18]<br>
Tolerancia = 0.0001<br>
Valores iniciales: [0, 0, 0]<br>

### Resultado
x ≈ 0.422<br>
y ≈ 1.804<br>
z ≈ 1.175<br>

---

## Método de Jacobi
<a name="método-de-jacobi"></a>

### Pseudocódigo

Proceso Jacobi
  
    Para i desde 0 hasta n-1 hacer
        Para j desde 0 hasta n-1 hacer
            Leer A[i][j]
        Fin Para
        Leer b[i]
    Fin Para

    // Inicializar variables
    Definir x[n], xNuevo[n]
    Para i desde 0 hasta n-1 hacer
        x[i] = 0
    Fin Para
    
    iteraciones = 0
    tolerancia = 0.0001
    maxIter = 100
    
    // Iteraciones
    Mientras iteraciones < maxIter hacer
        error = 0
        
        Para i desde 0 hasta n-1 hacer
            suma = 0
            Para j desde 0 hasta n-1 hacer
                Si j ≠ i entonces
                    suma = suma + A[i][j] * x[j]
                Fin Si
            Fin Para
            xNuevo[i] = (b[i] - suma) / A[i][i]
            error = Máx(error, |xNuevo[i] - x[i]|)
        Fin Para
        
        Si error < tolerancia entonces
            Imprimir "Convergencia en ", iteraciones, " iteraciones"
            Terminar
        Fin Si
        
        // Actualizar solución
        Para i desde 0 hasta n-1 hacer
            x[i] = xNuevo[i]
        Fin Para
        
        iteraciones = iteraciones + 1
    Fin Mientras
    
    Imprimir "Solución:"
    Para i desde 0 hasta n-1 hacer
        Imprimir "x", i+1, " = ", x[i]
    Fin Para
Fin Proceso

### Caso de prueba

Dado el siguiente sistema de ecucaciones determinar el valor de las variables: X1, x2, x3 <br>

4x - y + z = 7<br>
4x - 8y + z = -21<br>
-2x + y + 5z = 15<br>

### Datos de entrada
A = [[4, -1, 1], [4, -8, 1], [-2, 1, 5]]<br>
b = [7, -21, 15]<br>
Tolerancia = 0.0001<br>
Valores iniciales: [0, 0, 0]<br>

### Resultado
x = 2.0<br>
y = 4.0<br>
z = 3.0<br>