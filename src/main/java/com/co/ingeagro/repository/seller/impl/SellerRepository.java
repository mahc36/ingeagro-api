package com.co.ingeagro.repository.seller.impl;

import com.co.ingeagro.data.SellerData;
import com.co.ingeagro.repository.seller.ISellerRepository;
import com.co.ingeagro.repositoryjpa.SellerRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SellerRepository implements ISellerRepository {

    private final SellerRepositoryJPA repositoryJPA;

    @Autowired
    public SellerRepository(SellerRepositoryJPA repositoryJPA) {
        this.repositoryJPA = repositoryJPA;
    }

    @Override
    public SellerData findByUserId(Long userId) {
        return repositoryJPA.findByUserId(userId);
    }

    @Override
    public SellerData save(SellerData seller) {
        return repositoryJPA.save(seller);
    }
}
