package com.dbms.inventorysystem.service;

import com.dbms.inventorysystem.model.Payment;
import com.dbms.inventorysystem.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Integer id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public void savePayment(Payment payment) {
        paymentRepository.save(payment);
    }

    public void deletePayment(Integer id) {
        paymentRepository.deleteById(id);
    }
}