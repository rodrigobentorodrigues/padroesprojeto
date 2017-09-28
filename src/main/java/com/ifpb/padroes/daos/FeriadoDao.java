
package com.ifpb.padroes.daos;

import com.ifpb.padroes.entidades.Feriado;
import com.ifpb.padroes.interfaces.Dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class FeriadoDao implements Dao<Feriado>{

    private EntityManager em;
    
    public FeriadoDao(){
        this.em = Persistence.createEntityManagerFactory("UPersistence").
                createEntityManager();
    }
    
    @Override
    public void adicionar(Feriado objeto) {
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remover(Feriado objeto) {
        Feriado auxiliar = buscaPorId(objeto.getId());
        em.getTransaction().begin();
        em.remove(auxiliar);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void atualizar(Feriado objeto) {
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Feriado buscaPorId(int id) {
        return em.find(Feriado.class, id);
    }

    @Override
    public List<Feriado> listarTodos() {
        List<Feriado> feriados = em.createQuery("SELECT f FROM Feriado f",
                Feriado.class).getResultList();
        return feriados;
    }
    
}