package com.luiz.productmanagementapi.models;

import lombok.Data;

@Data
public class Product {
    private Integer id;
    private String name;
    private Double price;
}
