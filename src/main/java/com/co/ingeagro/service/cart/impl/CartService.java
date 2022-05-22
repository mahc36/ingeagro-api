package com.co.ingeagro.service.cart.impl;

import com.co.ingeagro.converter.Converter;
import com.co.ingeagro.converter.cart.CartConverter;
import com.co.ingeagro.data.CartData;
import com.co.ingeagro.exception.IngeagroException;
import com.co.ingeagro.model.Buyer;
import com.co.ingeagro.model.Cart;
import com.co.ingeagro.model.Product;
import com.co.ingeagro.model.SellProduct;
import com.co.ingeagro.model.form.AddToCartForm;
import com.co.ingeagro.repository.cart.ICartRepository;
import com.co.ingeagro.service.buyer.IBuyerService;
import com.co.ingeagro.service.cart.ICartService;
import com.co.ingeagro.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class CartService implements ICartService {

    private ICartRepository repository;
    private IProductService productService;
    private IBuyerService buyerService;
    private Converter<CartData, Cart> converter;

    @Autowired
    public CartService(ICartRepository repository, CartConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public Cart getACartById(Long cartId) {
        if(Objects.isNull(cartId) || cartId <= 0){
            Cart cart = Cart.builder().build();
            CartData newCart = repository.getANewCart(converter.convert2Data(cart));
            return converter.convert2Model(newCart);
        }
        else{
            CartData cartData = repository.getACartById(cartId);
            return converter.convert2Model(cartData);
        }
    }

    @Override
    public Cart addProduct(AddToCartForm addToCartForm) throws IngeagroException {
        Product product = productService.findById(addToCartForm.getProductId());
        Cart cart = this.getACartById(addToCartForm.getCartId());
        SellProduct sellProduct = SellProduct.builder()
                .quantity(addToCartForm.getQty())
                .product(product).build();

        if(Objects.nonNull(cart)){
            if(Objects.nonNull(cart.getProducts()) && cart.getProducts().size() > 0){
                cart.getProducts().add(sellProduct);
                repository.addProduct(converter.convert2Data(cart));
            }
            else{
             cart.setProducts(List.of(sellProduct));
            }
            if(Objects.isNull(cart.getUser())){
                cart.setUser(buyerService.getByUserId(addToCartForm.getBuyerId()));
            }
        }
        return cart;
    }

    @Override
    public Cart getANewCart(Long buyerId) {
        Buyer buyer = Buyer.builder().id(buyerId).build();
        Cart cart = Cart.builder().user(buyer).build();
        CartData newCart = repository.getANewCart(converter.convert2Data(cart));
        return converter.convert2Model(newCart);
    }
}
