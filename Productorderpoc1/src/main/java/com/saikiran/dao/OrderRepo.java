package com.saikiran.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saikiran.model.Orders;

public interface OrderRepo extends JpaRepository<Orders,Integer>{

}
