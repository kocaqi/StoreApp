package com.localweb.thelogin.thelogin.controller;

import com.localweb.thelogin.thelogin.entities.*;
import com.localweb.thelogin.thelogin.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderProductService orderProductService;
    @Autowired
    ClientService clientService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String showOrders(Model model, Principal principal) {
        String email = principal.getName();
        User user = userService.findUserByEmail(email);
        List<Order> orders = new ArrayList<>();

        if(user.getRoles().contains("ROLE_ADMIN")){
            orders = orderService.findAll();
        }
        else{
            orders = orderService.findAllByUser(user);
        }
        for (Order order : orders) {
            order.setOrderProducts(orderProductService.findProductsByOrder(order));
        }
        model.addAttribute("orders", orders);
        return "order/orders";
    }

    @PostMapping("/add")
    public String add(@RequestParam("clientId") int id, Model model, Principal principal) {
        Client client = clientService.getClient(id);
        Order order = new Order();
        order.setClient_id(client);
        order.setDateCreated(LocalDate.now());
        order.setDateUpdated(LocalDate.now());
        String email = principal.getName();
        User user = userService.findUserByEmail(email);
        order.setUser(user);
        orderService.save(order);
        model.addAttribute("order", order);
        return "order/order-form";
    }

    @GetMapping("/selectProduct")
    public String selectProduct(@RequestParam("orderId") int id, Model model) {
        Order order = orderService.getOrder(id);
        model.addAttribute("order", order);
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "order/add-product-to-order";
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestParam("productId") int productId,
                             @RequestParam("orderId") int orderId,
                             Model model) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setOrder(orderService.getOrder(orderId));
        orderProduct.setProduct(productService.getProduct(productId));
        orderProduct.setDateCreated(LocalDate.now());
        orderProduct.setDateUpdated(LocalDate.now());
        model.addAttribute("orderProduct", orderProduct);
        return "order/select-product-quantity";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(
            @RequestParam("quantity") double quantity,
            @ModelAttribute("orderProduct") OrderProduct orderProduct,
            Model model) {
        orderProduct.setQuantity(quantity);
        double amount = quantity * orderProduct.getProduct().getPrice();
        orderProduct.setAmount(amount);
        double orderAmount = orderProduct.getOrder().getAmount() + amount;
        orderProduct.getOrder().setAmount(orderAmount);
        orderProduct.getProduct().setStock(orderProduct.getProduct().getStock() - quantity);
        orderProduct.setDateCreated(LocalDate.now());
        orderProduct.setDateUpdated(LocalDate.now());
        orderProductService.save(orderProduct);
        orderService.save(orderProduct.getOrder());
        productService.save(orderProduct.getProduct());
        model.addAttribute("order", orderProduct.getOrder());
        model.addAttribute("products", orderProduct.getOrder().getOrderProducts());
        return "order/show-single-order";
    }

}
