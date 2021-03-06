package main.modelo;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Produto> produtos = new ArrayList<>();

    public CarrinhoDeCompras() {

    }

    public CarrinhoDeCompras(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void adiciona(Produto produto) {
        this.produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
