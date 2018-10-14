package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ProductService {
    ProductInfo findOne(Integer id);

    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll (Pageable pageable);

    ProductInfo save(ProductInfo ProductInfo);

    // 加库存

    // 减库存
}
