package com.dbms.inventorysystem.controller;

import com.dbms.inventorysystem.model.Stock;
import com.dbms.inventorysystem.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public String listStock(Model model) {
        model.addAttribute("stocks", stockService.getAllStocks());
        return "stock/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("stock", new Stock());
        return "stock/add";
    }

    @PostMapping("/add")
    public String addStock(@ModelAttribute Stock stock) {
        stockService.saveStock(stock);
        return "redirect:/stock";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("stock", stockService.getStockById(id));
        return "stock/edit";
    }

    @PostMapping("/edit/{id}")
    public String editStock(@PathVariable Integer id, @ModelAttribute Stock stock) {
        stock.setId(id);
        stockService.saveStock(stock);
        return "redirect:/stock";
    }

    @GetMapping("/delete/{id}")
    public String deleteStock(@PathVariable Integer id) {
        stockService.deleteStock(id);
        return "redirect:/stock";
    }
}