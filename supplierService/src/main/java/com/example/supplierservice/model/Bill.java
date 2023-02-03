package com.example.supplierservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Bill {
    private Long id;
    private Date billingDate;
    private Collection<ProductItem> productItems;
    private Customer customer;
    private Long customerId;
}
