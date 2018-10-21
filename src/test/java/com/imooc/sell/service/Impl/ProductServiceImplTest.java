package com.imooc.sell.service.Impl;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.dto.CartDTO;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.ProductStatusEnum;
import com.imooc.sell.repository.ProductInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Slf4j
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo productInfo = productService.findOne(1);
        Assert.assertEquals(new Integer(1), productInfo.getId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> result = productService.findUpAll();
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0, 2);
        Page<ProductInfo> result = productService.findAll(request);
        Assert.assertNotEquals(0, result.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();

        productInfo.setProductName("双皮奶");
        productInfo.setProductPrice(new BigDecimal(5.20));
        productInfo.setProductStock(10);
        productInfo.setCategoryType(3);
        productInfo.setProductDescription("好喝的双皮蛋粥");
        productInfo.setProductIcon("http://xxxx.com");
        productInfo.setProductStatus(1);

        ProductInfo result = productService.save(productInfo);

        Assert.assertNotNull(result);
    }

    @Test
    public void decreaseStockTest () {
        ProductInfo productInfo = productService.findOne(1);
        if (productInfo == null) {
            throw new RuntimeException("无Id 为一的产品 请添加产品");
        }
        Integer count = productInfo.getProductStock() - 2;

        List<CartDTO> cartDTOList = new ArrayList<>();
        CartDTO cart1 = new CartDTO(1, 2);
        cartDTOList.add(cart1);

        productService.decreaseStock(cartDTOList);
        ProductInfo productInfoChange = productService.findOne(1);
        if (productInfoChange == null) {
            throw new RuntimeException("无Id 为一的产品 请添加产品");
        }
        System.out.println(count);
        System.out.println(productInfo.getProductStock());
        // Assert.assertNotEquals(count, productInfoChange.getProductStock());
    }
}