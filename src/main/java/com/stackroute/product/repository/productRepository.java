package com.stackroute.product.repository;

import com.stackroute.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends MongoRepository<Product,String>{

}
