# Documentación Técnica: Módulo de Cálculo de Compras y Descuentos

## 1. Descripción del problema
El sistema realiza los cálculos de importes, validaciones de transacciones y aplicación de descuentos para una tienda en línea[cite: 1]. Es de suma importancia verificar estos cálculos para evitar errores monetarios que provoquen que un cliente pague de más o de menos, asegurando la integridad financiera y la confianza en la plataforma[cite: 1].

## 2. Reglas de negocio
* **Subtotal:** Se obtiene multiplicando el precio unitario del producto por la cantidad solicitada[cite: 1].
* **Validación de compra:** Una compra es válida únicamente si tanto el precio como la cantidad son estrictamente mayores que cero[cite: 1].
* **Descuento:** Se aplica un 10 % de descuento si el subtotal es mayor o igual a $1,000 pesos mexicanos. Si el subtotal es menor, no hay descuento[cite: 1].
* **Precio final:** Se calcula restando el descuento correspondiente al subtotal de la compra[cite: 1].

## 3. Casos de prueba

| Datos de Entrada | Resultado Esperado | Resultado Obtenido | Propósito del Caso |
| :--- | :--- | :--- | :--- |
| Precio: $100, Cantidad: 3 | 300.0 (Subtotal) | 300.0 | Verificar el cálculo estándar del subtotal[cite: 1]. |
| Precio: $0, Cantidad: 5 | false (Validez) | false | Comprobar rechazo con precio cero[cite: 1]. |
| Subtotal: $1,000 | 100.0 (Descuento) | 100.0 | Validar el límite exacto para aplicar el descuento[cite: 1]. |
| Subtotal: $1,000 | 900.0 (Precio Final) | 900.0 | Comprobar el precio final aplicando el descuento límite[cite: 1]. |

## 4. Resultados de ejecución
* **Pruebas totales ejecutadas:** 4 métodos evaluados con múltiples casos límite.
* **Pruebas exitosas (Passed):** 4
* **Pruebas fallidas (Failed):** 0

## 5. Errores que se pueden prevenir
1. **Error de operador estricto en el descuento:** Utilizar por error un operador de mayor que (`>`) en lugar de mayor o igual (`>=`) para el subtotal de $1,000, lo que negaría indebidamente el descuento al usuario[cite: 1].
2. **Falta de validación en valores negativos:** Permitir precios o cantidades negativas que alteren negativamente los totales de la transacción por omisión de filtros lógicos.

## 6. Conclusión
Las pruebas unitarias son fundamentales en el desarrollo de software de comercio electrónico, ya que permiten automatizar la verificación de las reglas de negocio, detectar fallos en los límites de condiciones financieras y garantizar la fiabilidad del sistema antes de su puesta en producción[cite: 1].