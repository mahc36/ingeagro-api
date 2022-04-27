package com.co.ingeagro.service.seller;

import com.co.ingeagro.model.Seller;

public interface ISellerService {

    /**
     *
     * @param userId to search a seller
     * @return the seller with all the information or null
     */
    Seller getByUserId(Long userId);

    /**
     *
     * @param seller to save
     * @return saved seller
     */
    Seller save(Seller seller);

}
