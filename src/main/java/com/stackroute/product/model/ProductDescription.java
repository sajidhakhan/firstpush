package com.stackroute.product.model;

public class ProductDescription {
    private Product product;

    public ProductDescription(Product product) {
        this.product = product;
    }

    public ProductDescription() {
    }


    @Override
    public String toString() {
        return "ProductDescription{" +
                "product=" + product +
                '}';
    }
}
