package com.infotech.isg.repository.jdbc;

import com.infotech.isg.repository.BalanceLogRepository;
import com.infotech.isg.domain.BalanceLog;

import java.util.Date;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * jdbc implementation for balance log repository.
 *
 * @author Sevak Gharibian
 */
@Repository
public class JdbcBalanceLogRepositoryImpl implements BalanceLogRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcBalanceLogRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public void save(BalanceLog balanceLog) {
        final String sql = "insert into info_topup_balance_log(MCI10000, MCI10000Timestamp, "
                                                            + "MCI20000, MCI20000Timestamp, "
                                                            + "MCI50000, MCI50000Timestamp, "
                                                            + "MCI100000, MCI100000Timestamp, "
                                                            + "MCI200000, MCI200000Timestamp, "
                                                            + "MCI500000, MCI500000Timestamp, "
                                                            + "MCI1000000, MCI1000000Timestamp, "
                                                            + "MTN, MTNTimestamp, "
                                                            + "Jiring, JiringTimestamp, "
                                                            + "Rightel, RightelTimestamp) "
                                                            + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[] {balanceLog.getMci10000(), balanceLog.getMci10000Timestamp(),
                                               balanceLog.getMci20000(), balanceLog.getMci20000Timestamp(),
                                               balanceLog.getMci50000(), balanceLog.getMci50000Timestamp(),
                                               balanceLog.getMci100000(), balanceLog.getMci100000Timestamp(),
                                               balanceLog.getMci200000(), balanceLog.getMci200000Timestamp(),
                                               balanceLog.getMci500000(), balanceLog.getMci500000Timestamp(),
                                               balanceLog.getMci1000000(), balanceLog.getMci1000000Timestamp(),
                                               balanceLog.getMtn(), balanceLog.getMtnTimestamp(),
                                               balanceLog.getJiring(), balanceLog.getJiringTimestamp(),
                                               balanceLog.getRightel(), balanceLog.getRightelTimestamp() });
    }

    @Override
    public BalanceLog findFirstRightelBalanceByDate(Date dt) {
        throw new UnsupportedOperationException();
    }
}
