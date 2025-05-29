# Métodos Numéricos - Pseudocódigos y Casos de Prueba.

## Índice
- [Método de Bisección](#método-de-bisección)
- [Método de la Regla Falsa](#método-de-la-regla-falsa)
- [Método de Newton-Raphson](#método-de-newton-raphson)
- [Método de Punto Fijo](#método-de-punto-fijo)
- [Método de la Secante](#método-de-la-secante)

---

## Método de Bisección
<a name="método-de-bisección"></a>

### Pseudocódigo

Proceso Biseccion
    Definir a, b, c, fa, fb, fc, error Como Real
    Definir iteraciones Como Entero
    
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
Función: cos(x) - x
Entradas:
a = 0
b = 1

Tolerancia = 0.0001
Salida esperada:
Raíz aproximada: 0.739085
Iteraciones: 14

---

## Método de la Regla Falsa
<a name="método-de-la-regla-falsa"></a>

### Pseudocódigo

Proceso ReglaFalsa
    Definir a, b, c, fa, fb, fc, error Como Real
    Definir iteraciones Como Entero
    
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
Función: ln(x) + x
Entradas:
a = 0.1
b = 1
Tolerancia = 0.0001
Salida esperada:
Raíz aproximada: 0.567143
Iteraciones: 6

---

## Método de Newton-Raphson
<a name="método-de-newton-raphson"></a>

### Pseudocódigo

Proceso NewtonRaphson
    Definir x, fx, dfx, xAnterior, error Como Real
    Definir iteraciones Como Entero
    
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
Función: x² - sen(x)
Entradas:
x0 = 0.5
Tolerancia = 0.0001
Salida esperada:
Raíz aproximada: 0.876726
Iteraciones: 4

---

## Método de Punto Fijo
<a name="método-de-punto-fijo"></a>

### Pseudocódigo

Proceso PuntoFijo
    Definir x, xAnterior, error Como Real
    Definir iteraciones Como Entero
    
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
Función: e^(-x)
Entradas:
x0 = 0.5
Tolerancia = 0.0001
Salida esperada:
Raíz aproximada: 0.567143
Iteraciones: 29

---

## Método de la Secante
<a name="método-de-la-secante"></a>

### Pseudocódigo

Proceso Secante
    Definir x0, x1, x2, fx0, fx1, error Como Real
    Definir iteraciones Como Entero
    
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
Función: x³ - 2x - 5
Entradas:
x0 = 2
x1 = 3
Tolerancia = 0.0001
Salida esperada:
Raíz aproximada: 2.094551
Iteraciones: 6