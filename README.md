👤 Información del Estudiante

Nombre completo: Ignacio Andrés Ibáñez Fariña 


Sección: 001A 


Carrera: Analista Programador Computacional 


Sede: Modalidad Online 

📘 Descripción General

Este proyecto implementa una simulación avanzada de logística multihilo para la empresa SpeedFast. El sistema coordina el flujo de pedidos desde una zona de carga centralizada hasta su entrega final, utilizando un modelo de Productor-Consumidor. La solución garantiza la integridad de los datos y evita condiciones de carrera mediante el uso de estructuras de datos concurrentes y un pool de hilos optimizado.

🧱 Estructura del Proyecto

📁 app/ 


Main.java - Orquestador del sistema, configura el pool de hilos y la carga inicial.


📁 model/ 


Pedido.java - Modelo de datos con gestión de estados mediante Enums.


EstadoPedido.java - Enumeración para los estados: PENDIENTE, EN_REPARTO y ENTREGADO.


Repartidor.java - Clase que implementa Runnable para la ejecución de hilos consumidores.


📁 control/ 


ZonaDeCarga.java - Monitor del sistema que gestiona la BlockingQueue de pedidos.

🎯 Conceptos de Concurrencia Aplicados

Gestión de Hilos (ExecutorService): Implementación de un FixedThreadPool de 3 hilos para reutilizar recursos y limitar la capacidad de ejecución simultánea.


Sincronización (BlockingQueue): Uso de LinkedBlockingQueue para asegurar que el retiro de pedidos por parte de los repartidores sea seguro y libre de colisiones (Thread-Safe).


Simulación de Latencia: Uso de Thread.sleep() para representar tiempos de transporte y entrega en un entorno de tiempo real.


Cierre Elegante: Implementación de shutdown() y awaitTermination() para garantizar que el programa finalice solo cuando todas las tareas hayan concluido exitosamente.

⚙️ Instrucciones de Ejecución
1. Clonar el repositorio:
git clone https://github.com/Broskiwi/Semana_5_SpeedFast.git

2. Abrir en IntelliJ IDEA

3. Ejecutar: Iniciar la clase Main.java ubicada en el paquete app.

Repositorio GitHub: https://github.com/Broskiwi/Semana_5_SpeedFast.git Fecha de entrega: 2026-02-07

© 2026 Duoc UC | Escuela de Informática y Telecomunicaciones
