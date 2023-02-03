package com.example.billingservice;

import com.example.billingservice.ClientRest.CustomerServiceClient;
import com.example.billingservice.ClientRest.InventoryServiceClient;
import com.example.billingservice.entities.Bill;
import com.example.billingservice.entities.Customer;
import com.example.billingservice.entities.Product;
import com.example.billingservice.entities.ProductItem;
import com.example.billingservice.reposetories.BillRepo;
import com.example.billingservice.reposetories.ProductRepo;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }



    @Bean
    CommandLineRunner start(BillRepo billRepo, ProductRepo productRepo,
                            CustomerServiceClient customerServiceClient,
                            InventoryServiceClient inventoryServiceClient)
    {
        return args -> {
            Bill bill=new Bill();
            Customer customer=new Customer();
            customer.setId(1L);
            customer.setName("ayman");
            customer.setEmail("ayman@mail.ma");
            bill.setCustomer(customer);
            bill.setBillingDate(new Date());
            bill.setCustomerId(1L);
            billRepo.save(bill);
            /*Customer customer=customerServiceClient.findCustomerById(1L);
            PagedModel<Product> all = inventoryServiceClient.findAll();
            Bill bill=new Bill();
            bill.setBillingDate(new Date());
            bill.setCustomer(customer);
            bill.setCustomerId(customer.getId());
            billRepo.save(bill);
            all.forEach(data->{
                ProductItem item=new ProductItem();
                item.setProduct(data);
                item.setProductId(data.getId());
                item.setPrice(data.getPrice());
                item.setQuantite(1+new Random().nextInt(100));
                item.setBill(bill);
                System.out.println(data);
                ProductItem save = productRepo.save(item);
                System.out.println("savedProduct:"+save);
            });*/
        };
    }


}
