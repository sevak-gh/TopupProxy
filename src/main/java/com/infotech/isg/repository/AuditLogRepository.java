package com.infotech.isg.repository;

import com.infotech.isg.domain.Audit;

/**
 * repository for audit log
 *
 * @author Sevak Gharibian
 */
public interface AuditLogRepository {
    public void save(Audit audit);
}
