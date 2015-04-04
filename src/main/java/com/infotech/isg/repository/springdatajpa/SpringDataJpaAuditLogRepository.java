package com.infotech.isg.repository.springdatajpa;

import com.infotech.isg.domain.Audit;
import com.infotech.isg.repository.AuditLogRepository;
import org.springframework.data.repository.Repository;

/**
 * Spring Data Jpa specialization of AuditLog repository
 *
 * @author Sevak Gharibian
 */
public interface SpringDataJpaAuditLogRepository extends AuditLogRepository, Repository<Audit, Integer>  {
}
