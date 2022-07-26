package com.electronstore.springboot.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.electronstore.springboot.model.Product;


@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {

}
