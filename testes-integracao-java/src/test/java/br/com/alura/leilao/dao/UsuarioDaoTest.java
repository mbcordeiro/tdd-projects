package br.com.alura.leilao.dao;

import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

class UsuarioDaoTest {
    private UsuarioDao usuarioDao;

    @Test
    void testeBuscaUsuarioPorUsername() {
        final EntityManager em = JPAUtil.getEntityManager();
        this.usuarioDao = new UsuarioDao(em);

        final Usuario usuario = new Usuario("fulano", "fulano@email.com","12345678");
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();

        final Usuario usuarioEncontrado = this.usuarioDao.buscarPorUsername(usuario.getNome());
        Assertions.assertNotNull(usuario);
    }
}
