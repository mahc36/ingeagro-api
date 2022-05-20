package com.co.ingeagro.service.seller.impl;

import com.co.ingeagro.converter.Converter;
import com.co.ingeagro.converter.product.ProductConverter;
import com.co.ingeagro.converter.seller.SellerConverter;
import com.co.ingeagro.data.ProductData;
import com.co.ingeagro.data.SellerData;
import com.co.ingeagro.exception.IngeagroException;
import com.co.ingeagro.model.Product;
import com.co.ingeagro.model.Seller;
import com.co.ingeagro.repository.seller.ISellerRepository;
import com.co.ingeagro.service.seller.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SellerService implements ISellerService {

    private final ISellerRepository repository;
    private final Converter<SellerData, Seller> sellerConverter;
    private final Converter<ProductData, Product> productConverter;

    @Autowired
    public SellerService(ISellerRepository repository,
                         SellerConverter sellerConverter,
                         ProductConverter productConverter) {
        this.repository = repository;
        this.sellerConverter = sellerConverter;
        this.productConverter = productConverter;
    }

    @Override
    public Seller getByUserId(Long userId) {
        return sellerConverter.convert2Model(repository.findByUserId(userId));
    }

    @Override
    public Seller save(Seller seller) {
        if(Objects.isNull(seller)){
            throw new NullPointerException("seller cannot be null");
        }
        return sellerConverter.convert2Model(repository.save(sellerConverter.convert2Data(seller)));
    }

    @Override
    public Seller getById(Long id) {
        return this.sellerConverter.convert2Model(this.repository.getById(id));
    }

    public void updateProducts(Long sellerId, List<Product> productList) throws IngeagroException {
        Seller byUserId = this.getById(sellerId);
        if(Objects.nonNull(byUserId)){
            if(Objects.nonNull(byUserId.getProducts()) && byUserId.getProducts().size() > 0){
                byUserId.getProducts().addAll(productList);
            }
            else{
                byUserId.setProducts(productList);
            }
            this.save(byUserId);
        }
        else{
            throw new IngeagroException("No se encontro usuario");
        }
    }

    @Override
    public List<Product> getAllBySellerId(Long sellerId) {
        return productConverter.convertAll2Model(repository.getAllBySellerId(sellerId));
    }
}
