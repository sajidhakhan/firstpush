package com.stackroute.product.service;

import com.stackroute.product.model.Product;

import java.util.List;

public interface productService {
    Product saveProduct(Product Product);
    void deleteProductByProductId(String productId) throws Exception;
     Product updateProductByProductId(Product Product) throws Exception;
     List<Product> getAllProducts();
     Product getProductByProductId(String productId);
}
