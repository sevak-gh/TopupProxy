package com.infotech.isg.repository.jpa;

import com.infotech.isg.domain.Balance;
import com.infotech.isg.repository.BalanceRepository;

import java.util.Date;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * jpa implementation for Balance repository.
 *
 * @author Sevak Gharibian
 */
@Repository
public class JpaBalanceRepositoryImpl implements BalanceRepository {

    private final Logger LOG = LoggerFactory.getLogger(JpaBalanceRepositoryImpl.class);

    @PersistenceContext
    EntityManager em;    

    @Override
    public void updateMCI10000(long amount, Date timestamp) {
        Query query = em.createQuery("UPDATE Balance balance set balance.mci10000 = :amount, balance.mci10000Timestamp = :timestamp");
        query.setParameter("amount", amount);
        query.setParameter("timestamp", timestamp);
        query.executeUpdate();
    }

    @Override
    public void updateMCI20000(long amount, Date timestamp) {
        Query query = em.createQuery("UPDATE Balance balance set balance.mci20000 = :amount, balance.mci20000Timestamp = :timestamp");
        query.setParameter("amount", amount);
        query.setParameter("timestamp", timestamp);
        query.executeUpdate();
   }

    @Override
    public void updateMCI50000(long amount, Date timestamp) {
        Query query = em.createQuery("UPDATE Balance balance set balance.mci50000 = :amount, balance.mci50000Timestamp = :timestamp");
        query.setParameter("amount", amount);
        query.setParameter("timestamp", timestamp);
        query.executeUpdate();
   }

    @Override
    public void updateMCI100000(long amount, Date timestamp) {
        Query query = em.createQuery("UPDATE Balance balance set balance.mci100000 = :amount, balance.mci100000Timestamp = :timestamp");
        query.setParameter("amount", amount);
        query.setParameter("timestamp", timestamp);
        query.executeUpdate();
   }

    @Override
    public void updateMCI200000(long amount, Date timestamp) {
        Query query = em.createQuery("UPDATE Balance balance set balance.mci200000 = :amount, balance.mci200000Timestamp = :timestamp");
        query.setParameter("amount", amount);
        query.setParameter("timestamp", timestamp);
        query.executeUpdate();
   }

    @Override
    public void updateMCI500000(long amount, Date timestamp) {
        Query query = em.createQuery("UPDATE Balance balance set balance.mci500000 = :amount, balance.mci500000Timestamp = :timestamp");
        query.setParameter("amount", amount);
        query.setParameter("timestamp", timestamp);
        query.executeUpdate();
   }

   @Override
   public void updateMCI1000000(long amount, Date timestamp) {
        Query query = em.createQuery("UPDATE Balance balance set balance.mci1000000 = :amount, balance.mci1000000Timestamp = :timestamp");
        query.setParameter("amount", amount);
        query.setParameter("timestamp", timestamp);
        query.executeUpdate();
   }

    @Override
    public void updateMTN(long amount, Date timestamp) {
        Query query = em.createQuery("UPDATE Balance balance set balance.mtn = :amount, balance.mtnTimestamp = :timestamp");
        query.setParameter("amount", amount);
        query.setParameter("timestamp", timestamp);
        query.executeUpdate();
   }

    @Override
    public void updateJiring(long amount, Date timestamp) {
        Query query = em.createQuery("UPDATE Balance balance set balance.jiring = :amount, balance.jiringTimestamp = :timestamp");
        query.setParameter("amount", amount);
        query.setParameter("timestamp", timestamp);
        query.executeUpdate();
   }
}
