# Solucion de ecuaciones diferenciales

- [Método de Un Paso (Euler)](#método-de-un-paso-euler)
- [Método de Paso Múltiple (Adams-Bashforth 4 pasos)](#método-de-paso-múltiple-adams-bashforth-4-pasos)
- [Método de Euler (Generalizado o para sistemas)](#método-de-euler-generalizado-o-para-sistemas)
- [Método de Runge-Kutta (RK4)](#método-de-runge-kutta-rk4)
- [Método de Taylor (Orden 2)](#método-de-taylor-orden-2)

---

## Método de Un Paso (Euler)
<a name="método-de-un-paso-euler"></a>

### Pseudocódigo

```plaintext
Entradas: 
  f(x, y): función que representa la derivada 
  x0: valor inicial de x 
  y0: valor inicial de y 
  h: tamaño del paso 
  n: número de pasos 

Proceso: 
  x ← x0 
  y ← y0 

  Para i desde 1 hasta n hacer: 
    y ← y + h * Φ(x, y, h) 
    x ← x + h 

Fin
```


### Caso de prueba
dy/dx = x + y<br>
y(0) = 1<br>

### Resultado
```
x       y     
0.0     1.0
0.1     1.1
0.2     1.22
0.3     1.36
0.4     1.53
0.5     1.72
0.6     1.94
0.7     2.20
0.8     2.49
0.9     2.82
1.0     3.19
```

---

## Método de Paso Múltiple (Adams-Bashforth 4 pasos)
<a name="método-de-paso-múltiple-adams-bashforth-4-pasos"></a>

### Pseudocódigo
Inicio

  Mostrar "Ingrese la función f(x, y) (ejemplo: 2*y - 6):"
    Leer funcionStr  // Ejemplo: "2*y - 6"

  Mostrar "Ingrese x0:"
    Leer x0

  Mostrar "Ingrese y0:"
    Leer y0

  Mostrar "Ingrese xf (valor final de x):"
    Leer xf

  Mostrar "Ingrese h (tamaño del paso):"
    Leer h

  n ← (xf - x0) / h  // Número de pasos

  x[0] ← x0
  y[0] ← y0

  Repetir para i desde 1 hasta 2
    k1 ← evaluar f(x[i-1], y[i-1])
    k2 ← evaluar f(x[i-1] + h/2, y[i-1] + (h/2) * k1)
    k3 ← evaluar f(x[i-1] + h/2, y[i-1] + (h/2) * k2)
    k4 ← evaluar f(x[i-1] + h, y[i-1] + h * k3)

    y[i] ← y[i-1] + (h / 6) * (k1 + 2*k2 + 2*k3 + k4)
    x[i] ← x[i-1] + h
  Fin Repetir

  Repetir para i desde 2 hasta n - 1
    f0 ← evaluar f(x[i], y[i])
    f1 ← evaluar f(x[i-1], y[i-1])
    f2 ← evaluar f(x[i-2], y[i-2])

    x[i+1] ← x[i] + h
    y[i+1] ← y[i] + (h / 12) * (23*f0 - 16*f1 + 5*f2)
  Fin Repetir

  Mostrar "Solución aproximada y(xf) ≈", y[n]

Fin

Subproceso evaluar(expresión, x, y)
  Asignar valor x a variable "x" en la expresión
  Asignar valor y a variable "y" en la expresión
  Retornar resultado de evaluar la expresión
Fin Subproceso

### Caso de prueba
dy/dx = y <br>
y(0) = 1 <br>

### Parametros
h = 0.2<br>
Intervalo: [0,1]<br>

### Resultado

```
Paso     t       y (AB4)     y (Exacto)     Error Abs.
0       0.00    1.000000     1.000000      0.000000
1       0.20    1.221400     1.221403      0.000003
2       0.40    1.491818     1.491825      0.000007
3       0.60    1.822106     1.822119      0.000013
4       0.80    2.225520     2.225541      0.000021
5       1.00    2.718251     2.718282      0.000031
```

---

## Método de Euler (Generalizado o para sistemas)
<a name="método-de-euler-generalizado-o-para-sistemas"></a>

### Pseudocódigo

```plaintext
Entradas: 
  f(x, y): función que representa la derivada o sistema de derivadas 
  x0: valor inicial de x 
  y0: valor inicial de y 
  h: tamaño del paso 
  n: número de pasos 

Proceso: 
  x ← x0 
  y ← y0 

  Para i desde 1 hasta n hacer: 
    y ← y + h * f(x, y) 
    x ← x + h 

Fin
```


### Caso de prueba
dy/dx = x + y<br>
y(0) = 1<br>

### Parametros
h = 0.1<br>
n = 10<br>

### Resultado

```
x       y
0.0     1.0
0.1     1.1
0.2     1.22
0.3     1.36
0.4     1.53
0.5     1.72
0.6     1.94
0.7     2.20
0.8     2.49
0.9     2.82
1.0     3.19
```

---

## Método de Runge-Kutta (RK4)
<a name="método-de-runge-kutta-rk4"></a>

### Pseudocódigo

```plaintext
Para i desde 1 hasta n hacer:
  k1 = f(x0, y0)
  k2 = f(x0 + h/2, y0 + (h/2) * k1)
  k3 = f(x0 + h/2, y0 + (h/2) * k2)
  k4 = f(x0 + h, y0 + h * k3)

  y1 = y0 + (h/6) * (k1 + 2*k2 + 2*k3 + k4)

  x0 = x0 + h
  y0 = y1

  Imprimir x0, y0
Fin Para
```

### Caso de prueba

dy/dx = y <br>
y(0) = 1<br>

## Parametros
h = 0.2<br>
Intervalo: [0,1]<br>

### ✅ Resultado

```
x       y
0.20    1.221402
0.40    1.491824
0.60    1.822118
0.80    2.225541
1.00    2.718279
```

---

## Método de Taylor (Orden 2)
<a name="método-de-taylor-orden-2"></a>

### Pseudocódigo

```plaintext
Función Taylor(f, a, x, n)

  Inicializar resultado = 0
  Inicializar factorial = 1
  Inicializar potencia = 1

  Para i desde 0 hasta n hacer
    Si i > 0 entonces
      factorial = factorial * i
      potencia = potencia * (x - a)
    Fin Si

    resultado = resultado + (f(i, a) * potencia / factorial)
  Fin Para

  Retornar resultado
Fin Función
```


### Caso de prueba
dv/dt = -9.8-0.1v<br>
v(0) = 0<br>
h = 0.1<br>

### Resultado
Aproximacion de Taylor: 2.7182818011463845

