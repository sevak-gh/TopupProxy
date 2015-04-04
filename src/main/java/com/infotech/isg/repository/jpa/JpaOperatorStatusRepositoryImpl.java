package com.infotech.isg.repository.jpa;

import com.infotech.isg.domain.OperatorStatus;
import com.infotech.isg.repository.OperatorStatusRepository;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * jpa implementation for OperatorStatus repository.
 *
 * @author Sevak Gharibian
 */
@Repository
public class JpaOperatorStatusRepositoryImpl implements OperatorStatusRepository {

    private final Logger LOG = LoggerFactory.getLogger(JpaOperatorStatusRepositoryImpl.class);

    @PersistenceContext
    EntityManager em;    

    @Override
    public OperatorStatus findById(int id) {
       return em.find(OperatorStatus.class, id);
    }

    @Override
    public void save(OperatorStatus operatorStatus) {
        if (operatorStatus.getId() == null) {
            throw new RuntimeException("adding new OperatorStatus not supported");
        }
        em.merge(operatorStatus);    
    }
}
