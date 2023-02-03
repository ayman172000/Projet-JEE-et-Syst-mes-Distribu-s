package com.example.billingservice.borokerKafka;

import com.example.billingservice.ClientRest.CustomerServiceClient;
import com.example.billingservice.ClientRest.InventoryServiceClient;
import com.example.billingservice.entities.Bill;
import com.example.billingservice.entities.Customer;
import com.example.billingservice.entities.Product;
import com.example.billingservice.entities.ProductItem;
import com.example.billingservice.reposetories.BillRepo;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class Kafkaservice {
    BillRepo billRepo;


    @Bean
    public Consumer<Bill> billsConsumer() {
        System.out.println("je suis dans consumer");
        return (input)->{
            System.out.println("********************");
            System.out.println(input.toString());
            System.out.println("********************");
            billRepo.save(input);
        };
    }
}
