package com.stackroute.product.service;

import com.stackroute.product.model.Product;
import com.stackroute.product.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class productServiceImpl implements productService
{
    private productRepository ProductRepository;

    @Autowired
    public productServiceImpl(productRepository productRepository) {
        ProductRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product Product) {
        Product.setProductId(UUID.randomUUID().toString());
        Product.setProductName(Product.getProductName());
        Product.setProductManfacturingDate(LocalDateTime.now());
        Product.setProductPrice(Product.getProductPrice());
        return ProductRepository.insert(Product);
    }

    @Override
    public void deleteProductByProductId(String productId) throws Exception {

        Optional<Product> productDb=this.ProductRepository.findById(productId);
        if(productDb.isPresent()){
            this.ProductRepository.delete(productDb.get());
        }
        else{
            throw new Exception("Product not found");
        }

    }

    @Override
    public Product updateProductByProductId(Product Product) throws Exception {

        Optional<com.stackroute.product.model.Product> productDb=this.ProductRepository.findById(Product.getProductId());
        if(productDb.isPresent()){
            com.stackroute.product.model.Product Product1 = productDb.get();
            Product1.setProductName(Product.getProductName());
            Product1.setProductManfacturingDate(Product.getProductManfacturingDate());
            Product1.setProductPrice(Product.getProductPrice());
            ProductRepository.save(Product1);
            return Product1;
        }
        else{
            throw new Exception("Product not found");
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return ProductRepository.findAll();
    }

    @Override
    public Product getProductByProductId(String productId) {
        Product Product = ProductRepository.findById(productId).get();
        return Product;
    }
}
