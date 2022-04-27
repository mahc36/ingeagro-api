package com.co.ingeagro.data;

import lombok.Data;
import javax.persistence.*;

@Table(name = "sell_product")
@Entity
@Data
public class SellProductData {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private Integer quantity;
    @OneToOne
    private ProductData product;
}
