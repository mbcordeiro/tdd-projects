package main;

import java.util.List;

public class Fatura {
    private String cliente;
    private double valor;
    private List<Pagamento> pagamentos;
    private boolean pago;

    public Fatura(String cliente, double valor) {
        this.cliente = cliente;
        this.valor = valor;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public void adicionaPagamento(Pagamento pagamento) {
        this.pagamentos.add(pagamento);
        double valorTotal = 0;
        for(Pagamento p : pagamentos) {
            valorTotal += p.getValor();
        }
        if(valorTotal >= this.valor) {
            this.pago = true;
        }
    }
}
