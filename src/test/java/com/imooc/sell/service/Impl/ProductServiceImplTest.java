package com.imooc.sell.service.Impl;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.enums.ProductStatusEnum;
import com.imooc.sell.repository.ProductInfoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo productInfo = productService.findOne(10);
        Assert.assertEquals(new Integer(10), productInfo.getId());
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
}