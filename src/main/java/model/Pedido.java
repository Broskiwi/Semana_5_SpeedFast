package model;

public class Pedido {
    private int id;
    private String direccionEntrega;
    private EstadoPedido estadoPedido;

    public Pedido(int id, String direccionEntrega, EstadoPedido estadoPedido) {
        this.id = id;
        this.direccionEntrega = direccionEntrega;
        this.estadoPedido = estadoPedido;
    }

    public int getId() {
        return id;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public EstadoPedido getEstado() {
        return estadoPedido;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public void setEstado(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public void setEstado(String nuevoEstado){
        try {
            this.estadoPedido = EstadoPedido.valueOf(nuevoEstado.toUpperCase());
        }catch (IllegalArgumentException e){
            System.out.println("Error: Estado " + nuevoEstado + " no es un estado válido.");
        }
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", direccionEntrega='" + direccionEntrega + '\'' +
                ", estadoPedido=" + estadoPedido +
                '}';
    }
}
