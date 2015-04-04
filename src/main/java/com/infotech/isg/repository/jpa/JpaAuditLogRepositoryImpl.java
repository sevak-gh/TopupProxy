package com.infotech.isg.repository.jpa;

import com.infotech.isg.domain.Audit;
import com.infotech.isg.repository.AuditLogRepository;

import java.util.Date;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * jpa implementation for audit log repository.
 *
 * @author Sevak Gharibian
 */
@Repository
public class JpaAuditLogRepositoryImpl implements AuditLogRepository {

    private final Logger LOG = LoggerFactory.getLogger(JpaAuditLogRepositoryImpl.class);

    @PersistenceContext
    EntityManager em;    

    @Override
    public void save(Audit audit) {
        em.persist(audit);
    }
}
