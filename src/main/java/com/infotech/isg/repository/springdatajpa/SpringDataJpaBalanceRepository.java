package com.infotech.isg.repository.springdatajpa;

import java.util.Date;
import com.infotech.isg.domain.Balance;
import com.infotech.isg.repository.BalanceRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;

/**
 * Spring Data Jpa specialization of Balance repository
 *
 * @author Sevak Gharibian
 */
public interface SpringDataJpaBalanceRepository extends BalanceRepository, Repository<Balance, Integer>  {

    @Override
    @Modifying
    @Query("update Balance balance set balance.mci10000 = :amount, balance.mci10000Timestamp = :timestamp")
    public void updateMCI10000(@Param("amount") long amount, 
                                @Param("timestamp") Date timestamp);
    @Override
    @Modifying
    @Query("update Balance balance set balance.mci20000 = :amount, balance.mci20000Timestamp = :timestamp")
    public void updateMCI20000(@Param("amount") long amount, 
                               @Param("timestamp") Date timestamp);
    @Override
    @Modifying
    @Query("update Balance balance set balance.mci50000 = :amount, balance.mci50000Timestamp = :timestamp")
    public void updateMCI50000(@Param("amount") long amount, 
                               @Param("timestamp") Date timestamp);
    @Override
    @Modifying
    @Query("update Balance balance set balance.mci100000 = :amount, balance.mci100000Timestamp = :timestamp")
    public void updateMCI100000(@Param("amount") long amount, 
                                @Param("timestamp") Date timestamp);
    @Override
    @Modifying
    @Query("update Balance balance set balance.mci200000 = :amount, balance.mci200000Timestamp = :timestamp")
    public void updateMCI200000(@Param("amount") long amount, 
                                @Param("timestamp") Date timestamp);
    @Override
    @Modifying
    @Query("update Balance balance set balance.mci500000 = :amount, balance.mci500000Timestamp = :timestamp")
    public void updateMCI500000(@Param("amount") long amount, 
                                @Param("timestamp") Date timestamp);
    @Override
    @Modifying
    @Query("update Balance balance set balance.mci1000000 = :amount, balance.mci1000000Timestamp = :timestamp")
    public void updateMCI1000000(@Param("amount") long amount, 
                                 @Param("timestamp") Date timestamp);
    @Override
    @Modifying
    @Query("update Balance balance set balance.mtn = :amount, balance.mtnTimestamp = :timestamp")
    public void updateMTN(@Param("amount") long amount, 
                          @Param("timestamp") Date timestamp);
    @Override
    @Modifying
    @Query("update Balance balance set balance.jiring = :amount, balance.jiringTimestamp = :timestamp")
    public void updateJiring(@Param("amount") long amount, 
                             @Param("timestamp") Date timestamp);
    @Override
    @Modifying
    @Query("update Balance balance set balance.rightel = :amount, balance.rightelTimestamp = :timestamp")
    public void updateRightel(@Param("amount") long amount, 
                              @Param("timestamp") Date timestamp);
}
