package com.localweb.thelogin.thelogin.controller;

import com.localweb.thelogin.thelogin.entities.Order;
import com.localweb.thelogin.thelogin.entities.OrderProduct;
import com.localweb.thelogin.thelogin.service.OrderProductService;
import com.localweb.thelogin.thelogin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderProductService orderProductService;

    @GetMapping("/")
    public String showOrders(Model model) {
        List<Order> orders = orderService.findAll();
        for (Order order : orders) {
            order.setOrders(orderProductService.findProductsByOrder(order));
        }
        model.addAttribute("orders", orders);
        return "order/orders";
    }

    @GetMapping("/add")
    public String add(){
        return "order/order-form";
    }

}
