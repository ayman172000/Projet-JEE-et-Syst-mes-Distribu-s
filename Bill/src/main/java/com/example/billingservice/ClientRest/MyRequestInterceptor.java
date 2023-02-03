package com.example.billingservice.ClientRest;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.keycloak.KeycloakPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Principal;

public class MyRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
/*        System.out.println("request bien interceptée:"+template.request());
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Principal principal = (Principal) authentication.getPrincipal();
        KeycloakPrincipal principalKeycloack= (KeycloakPrincipal) principal;
        String accessToken = principalKeycloack.getKeycloakSecurityContext().getTokenString();
        System.out.println("token:"+accessToken);
        // Ajoutez votre en-tête ici
        template.header("Authorization", "Bearer "+accessToken);*/

    }
}
