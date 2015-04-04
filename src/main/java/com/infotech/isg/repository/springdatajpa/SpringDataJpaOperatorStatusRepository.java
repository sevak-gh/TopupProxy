package com.infotech.isg.repository.springdatajpa;

import com.infotech.isg.domain.OperatorStatus;
import com.infotech.isg.repository.OperatorStatusRepository;
import org.springframework.data.repository.Repository;

/**
 * Spring Data Jpa specialization of OperatorStatus repository
 *
 * @author Sevak Gharibian
 */
public interface SpringDataJpaOperatorStatusRepository extends OperatorStatusRepository, Repository<OperatorStatus, Integer>  {
}
