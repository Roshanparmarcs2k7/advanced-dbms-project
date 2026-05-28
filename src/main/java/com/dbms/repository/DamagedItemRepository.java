package com.dbms.inventorysystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DamagedItemRepository extends JpaRepository<DamagedItem, Long> {
    // Baqi basic functions (save, findAll, delete) JpaRepository khud de dega
}