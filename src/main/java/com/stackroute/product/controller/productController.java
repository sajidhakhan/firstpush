package com.stackroute.product.controller;

import com.stackroute.product.model.Product;
import com.stackroute.product.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1")
public class productController {

    private productService ProductService;

    @Autowired
    public productController(productService productService) {
        ProductService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<List<Product>>((List<Product>) ProductService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<?> getProductByProductId(@PathVariable String productId) {

        Product Product = ProductService.getProductByProductId(productId);

        if (Product != null)
            return new ResponseEntity<com.stackroute.product.model.Product>(Product, HttpStatus.OK);

        return new ResponseEntity<String>("NotFound", HttpStatus.CONFLICT);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product Product)
            throws Exception {

        com.stackroute.product.model.Product saveProduct = ProductService.saveProduct(Product);
        return new ResponseEntity<com.stackroute.product.model.Product>(saveProduct, HttpStatus.CREATED);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateDomainByDomainId(@PathVariable String productId, @RequestBody Product Product)
            throws Exception {
        Product.setProductId(productId);
        return ResponseEntity.ok().body(this.ProductService.updateProductByProductId(Product));
    }

    @DeleteMapping("/products/{productId}")
    public HttpStatus deleteProductByProductId(@PathVariable String productId) throws Exception {
        this.ProductService.deleteProductByProductId(productId);
        return HttpStatus.OK;
    }
}
