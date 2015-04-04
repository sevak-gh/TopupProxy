package com.infotech.isg.repository;

import java.util.List;

import com.infotech.isg.domain.Transaction;

/**
 * repository for Transaction domain object.
 *
 * @author Sevak Gharibian
 */
public interface TransactionRepository {
    public List<Transaction> findByRefNumBankCodeClientId(String refNum, String bankCode, int clientId);
    public List<Transaction> findByStfProvider(Integer stf, int provider);
    public Transaction findByProviderOperatorTId(int provider, String operatorTId);
    public void save(Transaction transaction);
}
