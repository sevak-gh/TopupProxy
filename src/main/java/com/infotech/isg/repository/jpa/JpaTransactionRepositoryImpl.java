package com.infotech.isg.repository.jpa;

import com.infotech.isg.domain.Transaction;
import com.infotech.isg.repository.TransactionRepository;

import java.util.List;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * jpa implementation for Transaction repository.
 *
 * @author Sevak Gharibian
 */
@Repository
public class JpaTransactionRepositoryImpl implements TransactionRepository {

    private final Logger LOG = LoggerFactory.getLogger(JpaTransactionRepositoryImpl.class);

    @PersistenceContext
    EntityManager em;    

    @Override
    @SuppressWarnings("unchecked")
    public List<Transaction> findByRefNumBankCodeClientId(String refNum, String bankCode, int clientId) {
        Query query = em.createNamedQuery("findByRefNumBankCodeClientId", Transaction.class);
        query.setParameter("refNum", refNum);
        query.setParameter("bankCode", bankCode);
        query.setParameter("clientId", clientId);
        return  query.getResultList();    
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Transaction> findByStfProvider(Integer stf, int provider) {
        Query query = em.createNamedQuery("findByStfProvider", Transaction.class);
        query.setParameter("stf", stf);
        query.setParameter("provider", provider);
        return  query.getResultList();    
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public Transaction findByProviderOperatorTId(int provider, String operatorTId) {
        Query query = em.createNamedQuery("findByProviderOperatorTId", Transaction.class);
        query.setParameter("provider", provider);
        query.setParameter("operatorTId", operatorTId);
        List<Transaction> transactions = query.getResultList();
        if (transactions.isEmpty()) {
            return null;
        }
        return transactions.get(0);
    }
    
    @Override
    public void save(Transaction transaction) {
        if (transaction.getId() == null) {
            em.persist(transaction);
        } else {
            em.merge(transaction);
        }
    }
}
