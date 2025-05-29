# Métodos Numéricos para Solución de Ecuaciones

## Índice de Métodos

1. [Método de Bisección](#método-de-bisección)
2. [Método de la Regla Falsa](#método-de-la-regla-falsa)
3. [Método de Newton-Raphson](#método-de-newton-raphson)
4. [Método de Punto Fijo](#método-de-punto-fijo)
5. [Método de la Secante](#método-de-la-secante)


## Método de Bisección
<a name="método-de-bisección"></a>

### Pseudocódigo

Proceso Biseccion

    Escribir "Ingrese límite inferior del intervalo (a):"
    Leer a
    Escribir "Ingrese límite superior del intervalo (b):"
    Leer b
    Escribir "Ingrese tolerancia de error:"
    Leer error
    
    fa = cos(a) - a
    fb = cos(b) - b
    
    Si fa * fb >= 0 Entonces
        Escribir "No hay raíz en el intervalo"
    Sino
        iteraciones = 0
        Repetir
            c = (a + b) / 2
            fc = cos(c) - c
            
            Si fc = 0 O (b - a)/2 < error Entonces
                Terminar
            FinSi
            
            Si fa * fc < 0 Entonces
                b = c
                fb = fc
            Sino
                a = c
                fa = fc
            FinSi
            iteraciones = iteraciones + 1
        Hasta Que (b - a)/2 < error
        
        Escribir "Raíz aproximada: ", c
        Escribir "Iteraciones: ", iteraciones
    FinSi
FinProceso

### Caso de prueba
Función: cos(x) - x<br>
Entradas:<br>
a = 0<br>
b = 1
<br><br>
Tolerancia = 0.0001<br>
Salida esperada:<br>
Raíz aproximada: 0.74<br>
Iteraciones: 13

---

## Método de la Regla Falsa
<a name="método-de-la-regla-falsa"></a>

### Pseudocódigo

Proceso ReglaFalsa
    
    Escribir "Ingrese límite inferior (a):"
    Leer a
    Escribir "Ingrese límite superior (b):"
    Leer b
    Escribir "Ingrese tolerancia:"
    Leer error
    
    fa = ln(a) + a
    fb = ln(b) + b
    
    Si fa * fb >= 0 Entonces
        Escribir "Intervalo no válido"
    Sino
        iteraciones = 0
        Repetir
            c = (a * fb - b * fa) / (fb - fa)
            fc = ln(c) + c
            
            Si |fc| < error Entonces
                Terminar
            FinSi
            
            Si fa * fc < 0 Entonces
                b = c
                fb = fc
            Sino
                a = c
                fa = fc
            FinSi
            iteraciones = iteraciones + 1
        Hasta Que |fc| < error
        
        Escribir "Raíz: ", c
        Escribir "Iteraciones: ", iteraciones
    FinSi
FinProceso

### Caso de prueba
Función: ln(x) + x <br>
Entradas: <br>
a = 0.1<br>
b = 1
<br>
Tolerancia = 0.01<br>
Salida esperada:<br>
Raíz aproximada: 0.57<br>
Iteraciones: 5<br>

---

## Método de Newton-Raphson
<a name="método-de-newton-raphson"></a>

### Pseudocódigo

Proceso NewtonRaphson
    
    Escribir "Ingrese valor inicial (x0):"
    Leer x
    Escribir "Ingrese tolerancia:"
    Leer error
    
    iteraciones = 0
    Repetir
        xAnterior = x
        fx = x^2 - sen(x)
        dfx = 2x - cos(x)
        
        Si dfx = 0 Entonces
            Escribir "Derivada cero"
            Terminar
        FinSi
        
        x = x - fx / dfx
        iteraciones = iteraciones + 1
    Hasta Que |x - xAnterior| < error
    
    Escribir "Raíz: ", x
    Escribir "Iteraciones: ", iteraciones
FinProceso

### Caso de prueba
Función: x² - sen(x)<br>
Entradas:<br>
x0 = 0.5<br>
Tolerancia = 0.0001<br>
Salida esperada:<br>
Raíz aproximada: 0.88<br>
Iteraciones: 6<br>

---

## Método de Punto Fijo
<a name="método-de-punto-fijo"></a>

### Pseudocódigo

Proceso PuntoFijo
  
    Escribir "Ingrese valor inicial (x0):"
    Leer x
    Escribir "Ingrese tolerancia:"
    Leer error
    
    iteraciones = 0
    Repetir
        xAnterior = x
        x = e^(-x)
        iteraciones = iteraciones + 1
    Hasta Que |x - xAnterior| < error
    
    Escribir "Raíz: ", x
    Escribir "Iteraciones: ", iteraciones
FinProceso

### Caso de prueba
Función: e^(-x)<br>
Entradas:<br>
x0 = 0.5<br>
Tolerancia = 0.0001<br>
Salida esperada:<br>
Raíz aproximada: 0.57<br>
Iteraciones: 13<br>

---

## Método de la Secante
<a name="método-de-la-secante"></a>

### Pseudocódigo

Proceso Secante
    
    Escribir "Ingrese x0:"
    Leer x0
    Escribir "Ingrese x1:"
    Leer x1
    Escribir "Ingrese tolerancia:"
    Leer error
    
    fx0 = x0^3 - 2x0 - 5
    fx1 = x1^3 - 2x1 - 5
    iteraciones = 0
    
    Repetir
        x2 = x1 - fx1 * (x1 - x0) / (fx1 - fx0)
        iteraciones = iteraciones + 1
        
        x0 = x1
        fx0 = fx1
        x1 = x2
        fx1 = x1^3 - 2x1 - 5
    Hasta Que |fx1| < error
    
    Escribir "Raíz: ", x1
    Escribir "Iteraciones: ", iteraciones
FinProceso

### Caso de prueba
Función: x³ - 2x - 5<br>
Entradas:<br>
x0 = 2<br>
x1 = 3<br>
Tolerancia = 0.0001<br>
Salida esperada:<br>
Raíz aproximada: 2.09<br>
Iteraciones: 4<br>