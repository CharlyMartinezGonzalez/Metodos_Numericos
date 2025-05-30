# Métodos de Diferenciación e integración Numérica

## Índice
1. [Método del Trapecio](#método-del-trapecio)
2. [Método de Simpson 1/3](#método-de-simpson-13)
3. [Método de Simpson 3/8](#método-de-simpson-38)
4. [Método de Cuadratura Gaussiana](#método-de-cuadratura-gaussiana)

---

### Método del Trapecio
<a name="método-del-trapecio"></a>

### Pseudocódigo
```plaintext
1. Inicio
2. Mostrar "Método del Trapecio - Integración Numérica"
3. Solicitar al usuario:
   - "Ingresa el límite inferior a:"
   - "Ingresa el límite superior b:"
   - "Ingresa el número de subintervalos n:"
4. Leer a, b, n
5. Verificar validez de los datos:
   Si a <= 0 o b <= 0 entonces
      Imprimir "Error: ln(x) no está definido para x ≤ 0."
      Detener
   Fin Si
   Si n <= 0 entonces
      Imprimir "Error: el número de subintervalos debe ser mayor que cero."
      Detener
   Fin Si
6. Calcular ancho del subintervalo: h = (b - a) / n
7. Inicializar suma: suma = f(a) + f(b)
8. Para i desde 1 hasta n - 1 hacer
      xi = a + i * h
      suma = suma + 2 * f(xi)
   Fin Para
9. Calcular el resultado final: resultado = (h / 2) * suma
10. Mostrar el resultado: Imprimir "La aproximación de la integral es: ", resultado con 6 decimales
11. Detener
12. Función f(x): Retornar logaritmo natural de x (ln(x))
Fin Función
```

### Caso de prueba
Función: ln(x)<br>
Límites: a=1, b=2<br>
Subintervalos: n=100<br>

### Resultado
Aproximación: 0.3863<br>
Valor exacto: 0.3862<br>

---

### Método de Simpson 1/3
<a name="método-de-simpson-13"></a>

### Pseudocódigo

```plaintext
1. Inicio  
2. Definir la función f(x)  
3. Leer el límite inferior a, el límite superior b y el número de subintervalos n  
4. Si a >= b entonces  
      Mostrar error: "El límite inferior debe ser menor que el superior"  
      Detenerse  
   Fin si  
5. Si n mod 2 != 0 entonces  
      Mostrar error: "El número de subintervalos debe ser par"  
      Detenerse  
   Fin si  
6. Calcular: h = (b - a) / n  
7. Inicializar: suma = f(a) + f(b)  
8. Para i desde 1 hasta n - 1 hacer  
      Calcular: xi = a + i * h  
      Si i mod 2 = 0 entonces  
         suma = suma + 2 * f(xi)  
      Sino  
         suma = suma + 4 * f(xi)  
      Fin si  
   Fin Para  
9. Valor de integración = (h / 3) * suma  
10. Mostrar el valor de integración  
11. Fin
```

### Caso de prueba
Función: x²<br>
Límites: a=0, b=3<br>
Subintervalos: n=6<br>

### Resultado
Aproximación: 9.0<br>
Valor exacto: 9.0<br>

---

### Método de Simpson 3/8
<a name="método-de-simpson-38"></a>

### Pseudocódigo

```plaintext
1. Inicio  
2. Definir la función f(x)  
3. Leer el límite inferior a, el límite superior b y el número de subintervalos n  
4. Si a >= b entonces  
      Mostrar error: "El límite inferior debe ser menor que el superior"  
      Detenerse  
   Fin si  
5. Si n mod 3 ≠ 0 entonces  
      Mostrar error: "El número de subintervalos debe ser múltiplo de 3"  
      Detenerse  
   Fin si  
6. Calcular: h = (b - a) / n  
7. Inicializar: suma = f(a) + f(b)  
8. Para i desde 1 hasta n - 1 hacer  
      Calcular: xi = a + i * h  
      Si i mod 3 == 0 entonces  
         suma = suma + 2 * f(xi)  
      Sino  
         suma = suma + 3 * f(xi)  
      Fin si  
   Fin Para  
9. Calcular: Resultado = (3 * h / 8) * suma  
10. Mostrar el resultado  
11. Fin
```

### Caso de prueba
Función: sin(x)<br>
Límites: a=0, b=π/2<br>
Subintervalos: n=6<br>

### Resultado
Aproximación: 0.99998<br>
Valor exacto: 1.0<br>

---

### Método de Cuadratura Gaussiana
<a name="método-de-cuadratura-gaussiana"></a>

### Pseudocódigo

```plaintext
1. Inicio  
2. Definir la función f(x)  
3. Leer el límite inferior a, el límite superior b  
4. Leer el número de puntos de Gauss n (ejemplo: n = 2)  
5. Obtener los puntos xi y pesos wi correspondientes a n:  
   - Para n = 2:  
      xi[0] = -1/√3, wi[0] = 1  
      xi[1] = 1/√3, wi[1] = 1  
6. Inicializar suma ← 0  
7. Para i desde 0 hasta n - 1 hacer  
      Calcular: x ← ((b - a) / 2) * xi[i] + (a + b) / 2  
      Evaluar: fx ← f(x)  
      Acumular: suma ← suma + wi[i] * fx  
   Fin Para  
8. Calcular el valor de integración: resultado ← ((b - a) / 2) * suma  
9. Mostrar el valor de integración  
10. Fin  
```

### Caso de prueba
Función: ln(x)<br>
Límites: a=1, b=3<br>
Puntos: n=2<br>

### Resultado
Aproximación: 1.299283<br>
Valor exacto: 1.295836<br>