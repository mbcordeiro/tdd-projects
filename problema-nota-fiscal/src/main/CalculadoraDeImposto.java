package main;

public class CalculadoraDeImposto {
    private TabelaDePrecos tabela;
    public CalculadoraDeImposto(TabelaDePrecos tabela) {
        this.tabela = tabela;
    }

    public double calculaImposto(Pedido pedido) {
        return 0.0;
    }

    public double calculaImposto(Pedido p) {
        double taxa = tabela.pegaParaValor(p.getValor());
        return p.getValor() * taxa;
    }
}
