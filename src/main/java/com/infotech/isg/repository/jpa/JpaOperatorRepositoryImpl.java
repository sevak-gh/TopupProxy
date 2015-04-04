package com.infotech.isg.repository.jpa;

import com.infotech.isg.domain.Operator;
import com.infotech.isg.repository.OperatorRepository;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * jpa implementation for Operator repository.
 *
 * @author Sevak Gharibian
 */
@Repository
public class JpaOperatorRepositoryImpl implements OperatorRepository {

    private final Logger LOG = LoggerFactory.getLogger(JpaOperatorRepositoryImpl.class);

    @PersistenceContext
    EntityManager em;    

    @Override
    public Operator findById(int id) {
       return em.find(Operator.class, id);
    }
}

