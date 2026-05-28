package com.dbms.inventorysystem.controller;

import com.dbms.inventorysystem.model.Purchase;
import com.dbms.inventorysystem.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping
    public String listPurchases(Model model) {
        model.addAttribute("purchases", purchaseService.getAllPurchases());
        return "purchases/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("purchase", new Purchase());
        return "purchases/add";
    }

    @PostMapping("/add")
    public String addPurchase(@ModelAttribute Purchase purchase) {
        purchaseService.savePurchase(purchase);
        return "redirect:/purchases";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("purchase", purchaseService.getPurchaseById(id));
        return "purchases/edit";
    }

    @PostMapping("/edit/{id}")
    public String editPurchase(@PathVariable Integer id, @ModelAttribute Purchase purchase) {
        purchase.setId(id);
        purchaseService.savePurchase(purchase);
        return "redirect:/purchases";
    }

    @GetMapping("/delete/{id}")
    public String deletePurchase(@PathVariable Integer id) {
        purchaseService.deletePurchase(id);
        return "redirect:/purchases";
    }
}