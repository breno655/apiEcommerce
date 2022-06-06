package com.edu.unifacisa.ecommerce.controller;

import com.edu.unifacisa.ecommerce.model.Cart;
import com.edu.unifacisa.ecommerce.model.Product;
import com.edu.unifacisa.ecommerce.service.CartService;
import com.edu.unifacisa.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Cart> getCarts () {
        return cartService.findAll();
    }

    @RequestMapping(value = "{id}",
            method = RequestMethod.GET)
    public Cart findById (@PathVariable long id) {
        return cartService.findById(id);
    }

    @PostMapping("/create")
    public void insertProduct () {
        cartService.createCart();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct (@PathVariable long id) {
        cartService.deleteCart(id);
    }

    @RequestMapping(value = "/addProduct={id}",
            method = RequestMethod.GET)
    public void addProductInCart(@RequestBody Product product, @PathVariable long id) {
        cartService.addProduct(product, id);
    }

}
