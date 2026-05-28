package com.dbms.inventorysystem;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "damaged_items")
public class DamagedItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private Integer quantity;
    private String reason;
    private LocalDate reportedDate;

    // Constructors
    public DamagedItem() {}

    public DamagedItem(String productName, Integer quantity, String reason, LocalDate reportedDate) {
        this.productName = productName;
        this.quantity = quantity;
        this.reason = reason;
        this.reportedDate = reportedDate;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public LocalDate getReportedDate() { return reportedDate; }
    public void setReportedDate(LocalDate reportedDate) { this.reportedDate = reportedDate; }
}