package com.localweb.thelogin.thelogin.dao;

import com.localweb.thelogin.thelogin.entities.Order;
import com.localweb.thelogin.thelogin.entities.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductRepository  extends JpaRepository<OrderProduct, Integer> {

    @Query("select o from OrderProduct o where o.order=?1")
    List<OrderProduct> findProductsByOrder(Order order);

}
