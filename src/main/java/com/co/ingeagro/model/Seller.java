package com.co.ingeagro.model;

import com.co.ingeagro.data.ProductData;
import com.co.ingeagro.data.UserData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Seller {

    private Long id;
    private User user;
    List<Product> products;
    private LocalDateTime timeCreation;
}
