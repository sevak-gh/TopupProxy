package com.infotech.isg.repository.jdbc;

import com.infotech.isg.domain.Audit;
import com.infotech.isg.repository.AuditLogRepository;

import java.util.Date;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * jdbc implementation for audit log repository.
 *
 * @author Sevak Gharibian
 */
@Repository
public class JdbcAuditLogRepositoryImpl implements AuditLogRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcAuditLogRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Audit audit) {

        final String sql = "insert into info_topup_audit(username, bankCode, amount, channel, state, bankReceipt, orderId, consumer, "
                           + "customerIp, remoteIp, action, operator, status, isgDoc, oprDoc, timestamp, responseTime) values("
                           + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        if (audit.getId() != null) {
            throw new RuntimeException("updating Audit not supported");
        }

        jdbcTemplate.update(sql, new Object[] {audit.getUsername(), 
                                               audit.getBankCode(), 
                                               audit.getAmount(),
                                               audit.getChannel(), 
                                               audit.getState(),
                                               audit.getBankReceipt(),
                                               audit.getOrderId(), 
                                               audit.getConsumer(),
                                               audit.getCustomerIp(),
                                               audit.getRemoteIp(),
                                               audit.getAction(),
                                               audit.getOperatorId(),
                                               audit.getStatus(),
                                               audit.getIsgDoc(),
                                               audit.getOprDoc(),
                                               audit.getTimestamp(),
                                               audit.getResponseTime()
                                              });
    }
}

