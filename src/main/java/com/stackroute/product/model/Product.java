package com.stackroute.product.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "product")
public class Product {
    @Id
    private String productId;
    private String productName;
    private LocalDateTime productManfacturingDate;
    private String productPrice;

    public Product() {
    }

    public Product(String productId, String productName, LocalDateTime productManfacturingDate, String productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productManfacturingDate = productManfacturingDate;
        this.productPrice = productPrice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public LocalDateTime getProductManfacturingDate() {
        return productManfacturingDate;
    }

    public void setProductManfacturingDate(LocalDateTime productManfacturingDate) {
        this.productManfacturingDate = productManfacturingDate;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productManfacturingDate=" + productManfacturingDate +
                ", productPrice='" + productPrice + '\'' +
                '}';
    }
}
