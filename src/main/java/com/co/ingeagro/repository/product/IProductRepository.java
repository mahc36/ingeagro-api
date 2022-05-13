package com.co.ingeagro.repository.product;

import com.co.ingeagro.data.ProductData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductRepository {

    /**
     *
     * @param products to save
     * @return save products
     */
    List<ProductData> saveAll(List<ProductData> products);

    /**
     *
     * @return all products from db
     */
    List<ProductData> getAll();

    /**
     *
     * @param pageable page
     * @return paged products
     */
    Page<ProductData> getAll(Pageable pageable);

    /**
     *
     * @return a list of products by seller id
     */
    List<ProductData> getBySellerId(Long sellerId);


}
