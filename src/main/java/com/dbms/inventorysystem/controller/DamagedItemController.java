package com.dbms.inventorysystem.controller;

import com.dbms.inventorysystem.DamagedItem;
import com.dbms.inventorysystem.service.DamagedItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

@Controller
public class DamagedItemController {

    @Autowired
    private DamagedItemService damagedItemService;

    // 1. Saari list dekhne ke liye
    @GetMapping("/damaged-items")
    public String viewDamagedItems(Model model) {
        List<DamagedItem> listDamaged = damagedItemService.getAllDamagedItems();
        model.addAttribute("damagedItems", listDamaged);
        return "damaged/list"; // Pehle "[damaged-list]" dhoond raha tha, ab folder ke andar "list" dhoondega
    }

    // 2. Naya form kholne ke liye
    @GetMapping("/damaged-items/new")
    public String showAddForm(Model model) {
        DamagedItem item = new DamagedItem();
        item.setReportedDate(LocalDate.now()); 
        model.addAttribute("damagedItem", item);
        return "damaged/add"; // Rasta theek kar diya
    }

    // 3. Edit karne ka form kholne ke liye
    @GetMapping("/damaged-items/edit/{id}")
    public String showEditForm(@PathVariable(value = "id") Long id, Model model) {
        DamagedItem item = damagedItemService.getDamagedItemById(id);
        model.addAttribute("damagedItem", item);
        return "damaged/edit"; // Rasta theek kar diya
    }

    // 4. Data save ya update karne ke liye
    @PostMapping("/damaged-items/save")
    public String saveDamagedItem(@ModelAttribute("damagedItem") DamagedItem damagedItem) {
        damagedItemService.saveDamagedItem(damagedItem);
        return "redirect:/damaged-items"; 
    }
}