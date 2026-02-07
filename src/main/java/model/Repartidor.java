package model;

import control.ZonaDeCarga;

/*
Clase que representa a trabajador que retira y reparte pedidos de la zona de carga
Implementa interfaz Runnable para usar su metodo run() y ejecutar hilo de forma independiente
 */
public class Repartidor implements Runnable{
    private String nombre;
    private ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try {
                Pedido pedido = zonaDeCarga.retirarPedido();

                pedido.setEstado(EstadoPedido.EN_REPARTO);
                System.out.println("[Repartidor - " + nombre + "]" + " tomó pedido N° " + pedido.getId() + ". Estado: " + pedido.getEstado());

                Thread.sleep(2000);

                pedido.setEstado(EstadoPedido.ENTREGADO);
                System.out.println("[Repartidor - " + nombre + "] Entregando pedido N° " + pedido.getId() + "...");
                System.out.println("[Repartidor - " + nombre + "] Estado: " + pedido.getEstado());

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("[Repartidor - " + nombre + "] Interrumpido.");
                break;
            }
        }
    }
}
