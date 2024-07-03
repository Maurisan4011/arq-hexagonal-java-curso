package com.example.hexagonal.application;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductService {

    public String getProduct(){
        //Se implementa  logica para obtener productos
        return "Listado de productos 01-07-2024";
    }
}
