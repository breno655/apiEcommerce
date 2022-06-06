package com.edu.unifacisa.ecommerce.service;

import com.edu.unifacisa.ecommerce.model.Cart;
import com.edu.unifacisa.ecommerce.model.Product;
import com.edu.unifacisa.ecommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;


    public List<Cart> findAll () {
        return cartRepository.findAll();
    }

    public Cart findById (long id) {
        return cartRepository.findById(id).get();
    }

    public void createCart () {
        cartRepository.save(new Cart());
    }

    public void deleteCart (long id) {
        Cart cart = cartRepository.findById(id).get();
        cartRepository.delete(cart);
    }

    public void addProduct (Product product, long id) {
        Cart cartOld = findById(id);
        cartOld.getProduct().add(product);
        cartRepository.save(cartOld);
        deleteCart(id);
    }

}