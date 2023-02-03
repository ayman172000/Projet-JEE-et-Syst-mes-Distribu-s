package com.example.billingservice.web;

import com.example.billingservice.ClientRest.CustomerServiceClient;
import com.example.billingservice.ClientRest.InventoryServiceClient;
import com.example.billingservice.entities.Bill;
import com.example.billingservice.entities.Product;
import com.example.billingservice.entities.ProductItem;
import com.example.billingservice.reposetories.BillRepo;
import com.example.billingservice.reposetories.ProductRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.IDToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collection;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class BillRestController {
    private BillRepo billRepo;
    private ProductRepo productRepo;
    private CustomerServiceClient customerServiceClient;

    @GetMapping("/bills/full/{id}")
    public Bill getBill(@PathVariable Long id) throws Exception {
        customerServiceClient.findCustomerById(1L);
        Bill bill=billRepo.findById(id).get();
        bill.getProductItems().forEach(p->{
            Product product= (Product) productRepo.findAllByBill_Id(p.getId());

            p.setProduct(product);
            p.setProductName(product.getName());
        });

        bill.setCustomer(customerServiceClient.findCustomerById(bill.getCustomerId()));
        return bill;
    }

    @GetMapping("/bills/p")
    public void tst()
    {
        KeycloakAuthenticationToken authentication =
                (KeycloakAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        Principal principal = (Principal) authentication.getPrincipal();
        String userIdByToken = "";

        if (principal instanceof KeycloakPrincipal) {
            KeycloakPrincipal<KeycloakSecurityContext> kPrincipal = (KeycloakPrincipal<KeycloakSecurityContext>) principal;
            IDToken token = kPrincipal.getKeycloakSecurityContext().getIdToken();
            userIdByToken = token.getAccessTokenHash();
            System.out.println("###############################################"+userIdByToken);
        }
        customerServiceClient.findCustomerById(1L);
    }
}
