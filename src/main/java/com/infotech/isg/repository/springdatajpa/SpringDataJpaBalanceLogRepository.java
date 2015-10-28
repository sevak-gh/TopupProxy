package com.infotech.isg.repository.springdatajpa;

import com.infotech.isg.domain.BalanceLog;
import com.infotech.isg.repository.BalanceLogRepository;

import org.springframework.data.repository.Repository;

/**
 * Spring Data Jpa specialization of BalanceLog repository
 *
 * @author Sevak Gharibian
 */
public interface SpringDataJpaBalanceLogRepository extends BalanceLogRepository, Repository<BalanceLog, Integer>  {

}
