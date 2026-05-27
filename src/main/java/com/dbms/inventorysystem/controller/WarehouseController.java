package com.dbms.inventorysystem.controller;

import com.dbms.inventorysystem.model.Warehouse;
import com.dbms.inventorysystem.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/warehouses")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping
    public String listWarehouses(Model model) {
        model.addAttribute("warehouses", warehouseService.getAllWarehouses());
        return "warehouses/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("warehouse", new Warehouse());
        return "warehouses/add";
    }

    @PostMapping("/add")
    public String addWarehouse(@ModelAttribute Warehouse warehouse) {
        warehouseService.saveWarehouse(warehouse);
        return "redirect:/warehouses";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("warehouse", warehouseService.getWarehouseById(id));
        return "warehouses/edit";
    }

    @PostMapping("/edit/{id}")
    public String editWarehouse(@PathVariable Integer id, @ModelAttribute Warehouse warehouse) {
        warehouse.setId(id);
        warehouseService.saveWarehouse(warehouse);
        return "redirect:/warehouses";
    }

    @GetMapping("/delete/{id}")
    public String deleteWarehouse(@PathVariable Integer id) {
        warehouseService.deleteWarehouse(id);
        return "redirect:/warehouses";
    }
}