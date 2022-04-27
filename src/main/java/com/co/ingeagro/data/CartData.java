package com.co.ingeagro.data;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Table (name = "cart")
@Entity
@Data
public class CartData {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @OneToMany
    private List<SellProductData> products;
    @ManyToOne
    private BuyerData user;

}