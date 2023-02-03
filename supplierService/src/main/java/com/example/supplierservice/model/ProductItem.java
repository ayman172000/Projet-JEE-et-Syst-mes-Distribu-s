package com.example.supplierservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductItem {
    private Long id;
    private Long productId;
    private Product product;
    private double price;
    private  int quantite;
    private Bill bill;
    private String productName;

}
