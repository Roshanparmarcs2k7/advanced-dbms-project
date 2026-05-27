package com.dbms.inventorysystem.controller;

import com.dbms.inventorysystem.model.Supplier;
import com.dbms.inventorysystem.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public String listSuppliers(Model model) {
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        return "suppliers/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("supplier", new Supplier());
        return "suppliers/add";
    }

    @PostMapping("/add")
    public String addSupplier(@ModelAttribute Supplier supplier) {
        supplierService.saveSupplier(supplier);
        return "redirect:/suppliers";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("supplier", supplierService.getSupplierById(id));
        return "suppliers/edit";
    }

    @PostMapping("/edit/{id}")
    public String editSupplier(@PathVariable Integer id, @ModelAttribute Supplier supplier) {
        supplier.setId(id);
        supplierService.saveSupplier(supplier);
        return "redirect:/suppliers";
    }

    @GetMapping("/delete/{id}")
    public String deleteSupplier(@PathVariable Integer id) {
        supplierService.deleteSupplier(id);
        return "redirect:/suppliers";
    }
}