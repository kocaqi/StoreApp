package com.localweb.thelogin.thelogin.controller;

import com.localweb.thelogin.thelogin.dao.OrderProductRepository;
import com.localweb.thelogin.thelogin.dao.OrderRepository;
import com.localweb.thelogin.thelogin.entities.Order;
import com.localweb.thelogin.thelogin.entities.OrderProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderProductRepository orderProductRepository;

    @GetMapping("/orders")
    public String showOrders(Model model) {
        List<Order> orders = orderRepository.findAll();
        List<OrderProduct> orderProducts = new ArrayList<>();
        for (Order order : orders) {
            order.setOrders(orderProductRepository.findProductsByOrder(order));
        }
        model.addAttribute("orders", orders);
        return "order/orders";
    }

}
