package app;

import control.ZonaDeCarga;
import model.EstadoPedido;
import model.Pedido;
import model.Repartidor;

import java.util.concurrent.*;
/*
Punto de entrada para ejecución del programa
Aquí se configura zona de carga, se inicializan pedidos y se gestiona el pool de hilos para los repartidores.
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        BlockingQueue<Pedido> cola = new LinkedBlockingQueue<>();

        ZonaDeCarga zonaDeCarga = new ZonaDeCarga(cola);

        System.out.println("[Zona de carga inicializada]");

        zonaDeCarga.agregarPedido(new Pedido(1001, "Calle 1", EstadoPedido.PENDIENTE));
        zonaDeCarga.agregarPedido(new Pedido(1002, "Calle 2", EstadoPedido.PENDIENTE));
        zonaDeCarga.agregarPedido(new Pedido(1003, "Calle 3", EstadoPedido.PENDIENTE));
        zonaDeCarga.agregarPedido(new Pedido(1004, "Calle 4", EstadoPedido.PENDIENTE));
        zonaDeCarga.agregarPedido(new Pedido(1005, "Calle 5", EstadoPedido.PENDIENTE));

        System.out.println("");

        for (int i = 1; i <= 3; i++){
            executor.submit(new Repartidor("Repartidor " + i, zonaDeCarga));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(20, TimeUnit.SECONDS)){
                System.out.println("[Error] Algunos hilos no finalizaron correctamente.");
                executor.shutdown();
            }
        } catch (InterruptedException e) {
            executor.shutdown();
        }

        try {
            Thread.sleep(10000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }

        System.out.println("\n[Zona de carga vacía]");
        System.out.println("Todos los pedidos han sido entregados correctamente");
    }
}
