package test;

import main.CarrinhoDeCompras;
import main.Item;
import main.MaiorPreco;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaiorPrecoTest {
    @Test
    public void deveRetornarZeroSeCarrinhoVazio() {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        MaiorPreco algoritmo = new MaiorPreco();
        double valor = algoritmo.encontra(carrinho);
        assertEquals(0.0, valor, 0.0001);
    }

    @Test
    public void deveRetornarValorDoItemSeCarrinhoCom1Elemento() {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.adiciona(new Item("Geladeira", 1, 900.0));
        MaiorPreco algoritmo = new MaiorPreco();
        double valor = algoritmo.encontra(carrinho);
        assertEquals(900.0, valor, 0.0001);
    }

    @Test
    public void deveRetornarMaiorValorSeCarrinhoContemMuitosElementos() {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.adiciona(new Item("Geladeira", 1, 900.0));
        carrinho.adiciona(new Item("Fogão", 1, 1500.0));
        carrinho.adiciona(new Item("Máquina de Lavar", 1, 750.0));
        MaiorPreco algoritmo = new MaiorPreco();
        double valor = algoritmo.encontra(carrinho);
        assertEquals(1500.0, valor, 0.0001);
    }
}
