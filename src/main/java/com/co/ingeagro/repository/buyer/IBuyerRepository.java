package com.co.ingeagro.repository.buyer;

import com.co.ingeagro.data.BuyerData;

public interface IBuyerRepository {

    /**
     *
     * @param userId to search a buyer
     * @return a buyer with all the information or null
     */
    BuyerData getByUserId(Long userId);

    /**
     *
     * @param buyer to save
     * @return saved buyer
     */
    BuyerData save(BuyerData buyer);
}
