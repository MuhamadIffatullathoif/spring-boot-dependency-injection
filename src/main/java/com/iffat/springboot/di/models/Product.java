package com.iffat.springboot.di.models;

public class Product implements Cloneable{
    private String id;
    private String name;
    private Long price;

    public Product() {
    }

    public Product(String id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public Product clone() {
        try {
            Product clone = (Product) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            return new Product(this.getId(), this.getName(), this.getPrice());
        }
    }
}
