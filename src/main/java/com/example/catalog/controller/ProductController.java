package com.example.catalog.controller;

import com.example.catalog.model.Product;
import com.example.catalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/add-product")
    public String addProductForm() {
        return "addProduct";
    }

    @PostMapping("/add-product")
    public String addProduct(@ModelAttribute Product product) {
        service.save(product);
        return "redirect:/";
    }

    @GetMapping("/display-products")
    public String displayProducts(Model model) {
        List<Product> products = service.getAll();
        model.addAttribute("products", products);
        return "displayProduct";
    }
}
