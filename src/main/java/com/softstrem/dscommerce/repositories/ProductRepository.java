package com.softstrem.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softstrem.dscommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
