package com.infotech.isg.repository;

import com.infotech.isg.domain.BalanceLog;

import java.util.Date;

/**
 * repository for isg balance log
 *
 * @author Sevak Gharibian
 */
public interface BalanceLogRepository {
    public void save(BalanceLog balanceLog);
}
