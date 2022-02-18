package br.com.alura.leilao.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UsuarioDaoTest {
    private UsuarioDao usuarioDao;

    @Test
    void testeBuscaUsuarioPeloUsername() {
        this.usuarioDao = new UsuarioDao();
        Assertions.assertNotNull(usuarioDao);
    }
}
