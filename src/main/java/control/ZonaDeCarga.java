package control;

import model.Pedido;

import java.util.concurrent.BlockingQueue;
/*
Clase que se encarga de la gestión, almacenamiento y retiro de pedidos
Se usa estructura concurrente para permitir que múltiples repartidores no reitren un mismo pedido simultaneamente.
 */
public class ZonaDeCarga {

    private final BlockingQueue<Pedido> pedidosPendientes;

    public ZonaDeCarga(BlockingQueue<Pedido> pedidosPendientes) {
        this.pedidosPendientes = pedidosPendientes;
    }

    /*
    Metodo que agrega un pedido a la cola de pedidos pendientes
     */
    public void agregarPedido(Pedido p){
        pedidosPendientes.add(p);
        System.out.println("Pedido N° " + p.getId() + " agregado. Destino: " + p.getDireccionEntrega());
    }

    /*
    Metodo que permite el retiro de un pedido de forma segura
     */
    public Pedido retirarPedido() throws InterruptedException {
        Pedido retirarPedido = pedidosPendientes.take();
        System.out.println("[Zona de Carga] Pedido N° " + retirarPedido.getId() + " ha sido retirado.");
        return retirarPedido;
    }
}
