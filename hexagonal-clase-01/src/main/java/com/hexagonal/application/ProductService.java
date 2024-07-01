package com.hexagonal.application;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductService {
    public String getProducts() {
        // Implementación de obtención de productos
        return "Listado de productos";
    }
}
