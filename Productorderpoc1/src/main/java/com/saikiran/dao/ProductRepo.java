package com.saikiran.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saikiran.model.Products;

public interface ProductRepo extends JpaRepository<Products,Integer>{

}
