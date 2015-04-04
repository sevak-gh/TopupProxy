package com.infotech.isg.repository.springdatajpa;

import com.infotech.isg.domain.Operator;
import com.infotech.isg.repository.OperatorRepository;
import org.springframework.data.repository.Repository;

/**
 * Spring Data Jpa specialization of Operator repository
 *
 * @author Sevak Gharibian
 */
public interface SpringDataJpaOperatorRepository extends OperatorRepository, Repository<Operator, Integer>  {
}
