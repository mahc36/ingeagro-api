package com.co.ingeagro.repository.product.impl;

import com.co.ingeagro.data.ProductData;
import com.co.ingeagro.repository.product.IProductRepository;
import com.co.ingeagro.repositoryjpa.ProductRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    private ProductRepositoryJPA jpa;

    @Autowired
    public ProductRepository(ProductRepositoryJPA jpa) {
        this.jpa = jpa;
    }

    @Override
    public List<ProductData> saveAll(List<ProductData> products) {
        return jpa.saveAll(products);
    }

    @Override
    public List<ProductData> getAll() {
        return jpa.findAll();
    }

    @Override
    public Page<ProductData> getAll(Pageable pageable) {
        return jpa.findAll(pageable);
    }

    @Override
    public List<ProductData> getBySellerId(Long sellerId){
        // TODO - Method not implemented
        return null;
    }

}
