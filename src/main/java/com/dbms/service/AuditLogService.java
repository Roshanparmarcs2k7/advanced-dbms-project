package com.dbms.inventorysystem.service;

import com.dbms.inventorysystem.model.AuditLog;
import com.dbms.inventorysystem.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditLogService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    public List<AuditLog> getAllAuditLogs() {
        return auditLogRepository.findAll();
    }

    public AuditLog getAuditLogById(Integer id) {
        return auditLogRepository.findById(id).orElse(null);
    }

    public void saveAuditLog(AuditLog auditLog) {
        auditLogRepository.save(auditLog);
    }

    public void deleteAuditLog(Integer id) {
        auditLogRepository.deleteById(id);
    }
}