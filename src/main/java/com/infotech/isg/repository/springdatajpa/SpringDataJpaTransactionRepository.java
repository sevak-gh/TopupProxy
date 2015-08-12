package com.infotech.isg.repository.springdatajpa;

import java.util.List;
import com.infotech.isg.domain.Transaction;
import com.infotech.isg.repository.TransactionRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Spring Data Jpa specialization of Transaction repository
 *
 * @author Sevak Gharibian
 */
public interface SpringDataJpaTransactionRepository extends TransactionRepository, Repository<Transaction, Long>  {

    @Override
    @Query(name="findByRefNumBankCodeClientId")
    public List<Transaction> findByRefNumBankCodeClientId(@Param("refNum") String refNum, 
                                                          @Param("bankCode") String bankCode, 
                                                          @Param("clientId") int clientId);
    @Override
    @Query(name="findByStfProvider")
    public List<Transaction> findByStfProvider(@Param("stf") Integer stf, 
                                               @Param("provider") int provider);

    @Override
    @Query(name="findByProviderOperatorTId")
    public Transaction findByProviderOperatorTId(@Param("provider")int provider, 
                                                 @Param("operatorTId") String operatorTId);
}
