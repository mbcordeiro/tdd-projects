package br.com.alura.leilao.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

class UsuarioDaoTest {
    private UsuarioDao usuarioDao;

    private EntityManager em;

    @Test
    void testeBuscaUsuarioPeloUsername() {
        this.usuarioDao = new UsuarioDao(em);
        Assertions.assertNotNull(usuarioDao);
    }
}
