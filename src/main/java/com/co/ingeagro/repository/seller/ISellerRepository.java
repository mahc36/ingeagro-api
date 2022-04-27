package com.co.ingeagro.repository.seller;

import com.co.ingeagro.data.SellerData;

public interface ISellerRepository {

    /**
     *
     * @param userId to search a seller
     * @return a seller with all the information or null
     */
    SellerData findByUserId(Long userId);

    /**
     *
     * @param seller to save
     * @return saved seller
     */
    SellerData save(SellerData seller);

}
