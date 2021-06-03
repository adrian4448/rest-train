package com.api.tpix.service;

import com.api.tpix.model.Cobranca;
import com.api.tpix.service.factory.JpaFactory;

import javax.persistence.TypedQuery;
import java.util.List;


public class CobrancaService {

    public Cobranca findByTxId(String txId) {
        Cobranca cobranca = JpaFactory.getEntityManager().find(Cobranca.class, txId);
        return cobranca;
    }

    public List<Cobranca> findCobrancasByPessoaFisica(Integer id) {
        String jpql = "select c from Cobranca c join fetch c.devedor where c.devedor.id = :id";
        TypedQuery<Cobranca> typedQuery = JpaFactory.getEntityManager().createQuery(jpql, Cobranca.class)
                .setParameter("id", id);
        List<Cobranca> cobrancas = typedQuery.getResultList();
        return cobrancas;
    }

}
