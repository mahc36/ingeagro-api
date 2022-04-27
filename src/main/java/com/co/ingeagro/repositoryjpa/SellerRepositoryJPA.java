package com.co.ingeagro.repositoryjpa;

import com.co.ingeagro.data.SellerData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA Seller Abstraction
 */
public interface SellerRepositoryJPA extends JpaRepository<SellerData, Long> {

    /**
     *
     * @param userId to search a seller
     * @return the seller with all the information or null
     */
    SellerData findByUserId(Long userId);

}
