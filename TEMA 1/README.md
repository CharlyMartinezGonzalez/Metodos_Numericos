# Tema 1: Errores en Métodos Numéricos

## Error de Redondeo
**Características:**  
- Ocurre al simplificar decimales en cálculos.  
- Es común en computadoras por cómo almacenan números.  
- Afecta resultados en operaciones repetidas.  

**Ejemplo:**  
Al sumar 0.1 + 0.2 en Python, el resultado no es 0.3 exacto, sino 0.30000000000000004.  

---

## Error Absoluto  
**Características:**  
- Mide la diferencia directa entre el valor real y el aproximado.  
- Usa las mismas unidades (cm, segundos, etc.).  
- No indica qué tan grave es el error en contexto.  

**Ejemplo:**  
Si mides un lápiz de 10 cm como 9.5 cm, el error absoluto es 0.5 cm.  

---

## Error Relativo  
**Características:**  
- Compara el error con el valor real.  
- Útil para entender la importancia del error.  
- Se expresa en porcentaje.  

**Ejemplo:**  
Si pesas una manzana de 153 g como 150 g, el error relativo es 1.96%.  

---

## Error de Truncamiento  
**Características:**  
- Surge al cortar procesos infinitos (como series matemáticas).  
- Depende de cuánto simplifiques el cálculo.  

**Ejemplo:**  
Usar π = 3.14 en lugar de π = 3.141592... al calcular el área de un círculo introduce un error pequeño.  

---

## Exactitud vs. Precisión  
**Características (Exactitud):**  
- Se refiere a qué tan cerca estás del valor verdadero.  
- Ejemplo: Decir que π es 3.1416 es más exacto que decir 3.14.  

**Características (Precisión):**  
- Se refiere a qué tan consistentes son tus resultados al repetirlos.  
- Ejemplo: Lanzar un dardo siempre en el mismo lugar (aunque no sea el centro) muestra precisión sin exactitud.  

---

### Conclusión  
Entender estos errores ayuda a tomar decisiones en ingeniería, programación y ciencia. Pequeños errores pueden generar grandes impactos, pero con técnicas adecuadas, se pueden controlar.