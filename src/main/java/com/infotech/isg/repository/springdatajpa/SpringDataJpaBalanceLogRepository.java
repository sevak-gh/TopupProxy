package com.infotech.isg.repository.springdatajpa;

import com.infotech.isg.domain.BalanceLog;
import com.infotech.isg.repository.BalanceLogRepository;

import java.util.Date;

import org.springframework.data.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Spring Data Jpa specialization of BalanceLog repository
 *
 * @author Sevak Gharibian
 */
public interface SpringDataJpaBalanceLogRepository extends BalanceLogRepository, Repository<BalanceLog, Integer>  {

    @Override
    @Query(name="findFirstRightelBalanceByDate", nativeQuery=true)
    public BalanceLog findFirstRightelBalanceByDate(@Param("date") Date dt);
}
