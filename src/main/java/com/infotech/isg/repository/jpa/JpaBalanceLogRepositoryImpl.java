package com.infotech.isg.repository.jpa;

import com.infotech.isg.domain.BalanceLog;
import com.infotech.isg.repository.BalanceLogRepository;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * jpa implementation for BalanceLog repository.
 *
 * @author Sevak Gharibian
 */
@Repository
public class JpaBalanceLogRepositoryImpl implements BalanceLogRepository {

    private final Logger LOG = LoggerFactory.getLogger(JpaBalanceLogRepositoryImpl.class);

    @PersistenceContext
    EntityManager em;    

    @Override
    public void save(BalanceLog balanceLog) {
        em.persist(balanceLog);
    }
}
