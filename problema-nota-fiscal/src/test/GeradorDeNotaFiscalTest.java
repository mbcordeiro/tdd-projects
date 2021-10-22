package test;

import main.*;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GeradorDeNotaFiscalTest {
//    @Test
//    public void devePersistirNFGerada() {
//        NFDao dao = Mockito.mock(NFDao.class);
//        GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(dao, null);
//        Pedido pedido = new Pedido("Mauricio", 1000, 1);
//        NotaFiscal nf = gerador.gera(pedido);
//        Mockito.verify(dao).persiste(nf);
//    }
//
//    @Test
//    public void deveEnviarNFGeradaParaSAP() {
//        NFDao dao = Mockito.mock(NFDao.class);
//        SAP sap = Mockito.mock(SAP.class);
//        GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(dao, sap);
//        Pedido pedido = new Pedido("Mauricio", 1000, 1);
//        NotaFiscal nf = gerador.gera(pedido);
//        Mockito.verify(sap).envia(nf);
//    }

    @Test
    public void deveInvocarAcoesPosteriores() {
        AcaoAposGerarNota acao1 = mock(AcaoAposGerarNota.class);
        AcaoAposGerarNota acao2 = mock(AcaoAposGerarNota.class);
        List<AcaoAposGerarNota> acoes = Arrays.asList(acao1, acao2);
        GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(acoes);
        Pedido pedido = new Pedido("Mauricio", 1000, 1);
        NotaFiscal nf = gerador.gera(pedido);
        Mockito.verify(acao1).executa(nf);
        Mockito.verify(acao2).executa(nf);
    }

    @Test
    public void deveConsultarATabelaParaCalcularValor() {
        // mockando uma tabela, que ainda nem existe
        Tabela tabela = mock(Tabela.class);
        // definindo o futuro comportamento "paraValor",
        // que deve retornar 0.2 caso o valor seja 1000.0
        when(tabela.paraValor(1000.0)).thenReturn(0.2);
        List<AcaoAposGerarNota> nenhumaAcao = Collections.emptyList();
        GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(nenhumaAcao, tabela);
        Pedido pedido = new Pedido("Mauricio", 1000, 1);
        NotaFiscal nf = gerador.gera(pedido);
        // garantindo que a tabela foi consultada
        Mockito.verify(tabela).paraValor(1000.0);
        assertEquals(1000 * 0.2, nf.getValor(), 0.00001);
    }

    @Test
    public void deveCalcularImpostoParaPedidosSuperioresA2000Reais() {
        TabelaDePrecos tabela = mock(TabelaDePrecos.class);
        // ensinando o mock a devolver 1 caso o método
        // pegaParaValor seja invocado com o valor 2500.0
        when(tabela.pegaParaValor(2500.0)).thenReturn(0.1);
        Pedido pedido = new Pedido(2500.0);
        CalculadoraDeImposto calculadora = new CalculadoraDeImposto(tabela);
        double valor = calculadora.calculaImposto(pedido);
        assertEquals(2500 * 0.1, valor, 0.00001);
    }
}
