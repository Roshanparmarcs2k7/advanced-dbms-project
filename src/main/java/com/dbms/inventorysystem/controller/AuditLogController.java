package com.dbms.inventorysystem.controller;

import com.dbms.inventorysystem.model.AuditLog;
import com.dbms.inventorysystem.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/audit-log")
public class AuditLogController {

    @Autowired
    private AuditLogService auditLogService;

    @GetMapping
    public String listAuditLogs(Model model) {
        model.addAttribute("auditLogs", auditLogService.getAllAuditLogs());
        return "audit-log/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("auditLog", new AuditLog());
        return "audit-log/add";
    }

    @PostMapping("/add")
    public String addAuditLog(@ModelAttribute AuditLog auditLog) {
        auditLogService.saveAuditLog(auditLog);
        return "redirect:/audit-log";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("auditLog", auditLogService.getAuditLogById(id));
        return "audit-log/edit";
    }

    @PostMapping("/edit/{id}")
    public String editAuditLog(@PathVariable Integer id, @ModelAttribute AuditLog auditLog) {
        auditLog.setId(id);
        auditLogService.saveAuditLog(auditLog);
        return "redirect:/audit-log";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuditLog(@PathVariable Integer id) {
        auditLogService.deleteAuditLog(id);
        return "redirect:/audit-log";
    }
}