package com.lenscart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lenscart.entity.Cart;

@Service
public interface ICartService {

	public List<Cart> getAllCartItems();

	public Cart addToCart(Cart cartItem);

	public void removeFromCart(int itemId);

}
