package com.dbms.inventorysystem.controller;

import com.dbms.inventorysystem.model.Payment;
import com.dbms.inventorysystem.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public String listPayments(Model model) {
        model.addAttribute("payments", paymentService.getAllPayments());
        return "payments/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("payment", new Payment());
        return "payments/add";
    }

    @PostMapping("/add")
    public String addPayment(@ModelAttribute Payment payment) {
        paymentService.savePayment(payment);
        return "redirect:/payments";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("payment", paymentService.getPaymentById(id));
        return "payments/edit";
    }

    @PostMapping("/edit/{id}")
    public String editPayment(@PathVariable Integer id, @ModelAttribute Payment payment) {
        payment.setId(id);
        paymentService.savePayment(payment);
        return "redirect:/payments";
    }

    @GetMapping("/delete/{id}")
    public String deletePayment(@PathVariable Integer id) {
        paymentService.deletePayment(id);
        return "redirect:/payments";
    }
}