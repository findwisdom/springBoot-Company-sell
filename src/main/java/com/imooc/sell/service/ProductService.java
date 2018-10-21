package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.dto.CartDTO;
import com.imooc.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ProductService {
    ProductInfo findOne(Integer id);

    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll (Pageable pageable);

    ProductInfo save(ProductInfo ProductInfo);

    // 加库存
    void increaseStock(List<CartDTO> cartDTOList);

    // 减库存
    void decreaseStock(List<CartDTO> cartDTOList);
}
