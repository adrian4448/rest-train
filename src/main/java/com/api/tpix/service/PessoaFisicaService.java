package com.api.tpix.service;

import com.api.tpix.model.Cobranca;
import com.api.tpix.model.PessoaFisica;
import com.api.tpix.service.factory.JpaFactory;

import javax.enterprise.inject.Typed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class PessoaFisicaService {

    public PessoaFisica findById(Integer id) {
        PessoaFisica pessoaFisica =  JpaFactory.getEntityManager().find(PessoaFisica.class, id);
        return pessoaFisica;
    }

    public List<PessoaFisica> findAll() {
        String jpql = "select p from PessoaFisica p";
        TypedQuery<PessoaFisica> typedQuery = JpaFactory.getEntityManager().createQuery(jpql, PessoaFisica.class);
        List<PessoaFisica> pessoasFisicas = typedQuery.getResultList();
        return pessoasFisicas;
    }

    public void addPessoaFisica(PessoaFisica pessoaFisica) {
        EntityManager entityManager = JpaFactory.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(pessoaFisica);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public PessoaFisica updatePessoaFisica(PessoaFisica pessoaFisica, Integer id) {
        EntityManager entityManager = JpaFactory.getEntityManager();
        entityManager.getTransaction().begin();
        pessoaFisica.setId(id);
        entityManager.merge(pessoaFisica);
        entityManager.getTransaction().commit();
        entityManager.close();
        return pessoaFisica;
    }

}
