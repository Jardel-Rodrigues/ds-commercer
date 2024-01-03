package com.softstrem.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softstrem.dscommerce.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
