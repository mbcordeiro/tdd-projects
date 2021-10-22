package main;

public class Pedido {
    private String cliente;
    private double valorTotal;
    private int quantidadeItens;

    public Pedido(String cliente, double valorTotal,
                  int quantidadeItens) {
        this.cliente = cliente;
        this.valorTotal = valorTotal;
        this.quantidadeItens = quantidadeItens;
    }

    public Pedido(double v) {
    }

    public String getCliente() {
        return cliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }

    public double getValor() {
        return 0;
    }
}
