package com.localweb.thelogin.thelogin.dao;

import com.localweb.thelogin.thelogin.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product getProductById(int id);

}
