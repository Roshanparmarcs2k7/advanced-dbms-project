package com.dbms.inventorysystem.controller;

import com.dbms.inventorysystem.model.OrderItem;
import com.dbms.inventorysystem.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping
    public String listOrderItems(Model model) {
        model.addAttribute("orderItems", orderItemService.getAllOrderItems());
        return "order-items/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("orderItem", new OrderItem());
        return "order-items/add";
    }

    @PostMapping("/add")
    public String addOrderItem(@ModelAttribute OrderItem orderItem) {
        orderItemService.saveOrderItem(orderItem);
        return "redirect:/order-items";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("orderItem", orderItemService.getOrderItemById(id));
        return "order-items/edit";
    }

    @PostMapping("/edit/{id}")
    public String editOrderItem(@PathVariable Integer id, @ModelAttribute OrderItem orderItem) {
        orderItem.setId(id);
        orderItemService.saveOrderItem(orderItem);
        return "redirect:/order-items";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrderItem(@PathVariable Integer id) {
        orderItemService.deleteOrderItem(id);
        return "redirect:/order-items";
    }
}