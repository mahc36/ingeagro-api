package com.co.ingeagro.service.seller.impl;

import com.co.ingeagro.converter.Converter;
import com.co.ingeagro.converter.seller.SellerConverter;
import com.co.ingeagro.data.SellerData;
import com.co.ingeagro.model.Seller;
import com.co.ingeagro.repository.seller.ISellerRepository;
import com.co.ingeagro.service.seller.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SellerService implements ISellerService {

    private final ISellerRepository repository;
    private final Converter<SellerData, Seller> sellerConverter;

    @Autowired
    public SellerService(ISellerRepository repository, SellerConverter sellerConverter) {
        this.repository = repository;
        this.sellerConverter = sellerConverter;
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
}
