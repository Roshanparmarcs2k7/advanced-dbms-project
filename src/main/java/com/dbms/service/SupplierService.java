package com.dbms.inventorysystem.service;

import com.dbms.inventorysystem.model.Supplier;
import com.dbms.inventorysystem.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(Integer id) {
        return supplierRepository.findById(id).orElse(null);
    }

    public void saveSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    public void deleteSupplier(Integer id) {
        supplierRepository.deleteById(id);
    }
}