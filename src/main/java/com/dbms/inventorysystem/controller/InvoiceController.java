package com.dbms.inventorysystem.controller;

import com.dbms.inventorysystem.model.Invoice;
import com.dbms.inventorysystem.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public String listInvoices(Model model) {
        model.addAttribute("invoices", invoiceService.getAllInvoices());
        return "invoices/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("invoice", new Invoice());
        return "invoices/add";
    }

    @PostMapping("/add")
    public String addInvoice(@ModelAttribute Invoice invoice) {
        invoiceService.saveInvoice(invoice);
        return "redirect:/invoices";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("invoice", invoiceService.getInvoiceById(id));
        return "invoices/edit";
    }

    @PostMapping("/edit/{id}")
    public String editInvoice(@PathVariable Integer id, @ModelAttribute Invoice invoice) {
        invoice.setId(id);
        invoiceService.saveInvoice(invoice);
        return "redirect:/invoices";
    }

    @GetMapping("/delete/{id}")
    public String deleteInvoice(@PathVariable Integer id) {
        invoiceService.deleteInvoice(id);
        return "redirect:/invoices";
    }
}