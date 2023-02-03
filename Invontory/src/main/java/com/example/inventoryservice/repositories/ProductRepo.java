package com.example.inventoryservice.repositories;

import com.example.inventoryservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
public interface ProductRepo extends JpaRepository<Product,Long> {
}
