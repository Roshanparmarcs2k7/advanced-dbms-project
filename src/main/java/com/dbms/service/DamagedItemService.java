package com.dbms.inventorysystem.service;

import com.dbms.inventorysystem.DamagedItem;
import com.dbms.inventorysystem.DamagedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DamagedItemService {

    @Autowired
    private DamagedItemRepository damagedItemRepository;

    // 1. Saari list lane ke liye
    public List<DamagedItem> getAllDamagedItems() {
        return damagedItemRepository.findAll();
    }

    // 2. Naya item save ya update karne ke liye
    public void saveDamagedItem(DamagedItem damagedItem) {
        damagedItemRepository.save(damagedItem);
    }

    // 3. ID ke zariye single product dhoondne ke liye (YEH MISSING THA)
    public DamagedItem getDamagedItemById(Long id) {
        return damagedItemRepository.findById(id).orElse(null);
    }
}