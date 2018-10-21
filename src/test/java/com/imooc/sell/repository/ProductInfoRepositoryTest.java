package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;
import java.security.PublicKey;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(new BigDecimal(3.20));
        productInfo.setProductStock(10);
        productInfo.setCategoryType(1);
        productInfo.setProductDescription("好吃的皮蛋粥");
        productInfo.setProductIcon("http://xxxx.com");
        productInfo.setProductStatus(0);

        ProductInfo result = repository.save(productInfo);

        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus() {

        List<ProductInfo> result = repository.findByProductStatus(0);

        Assert.assertNotEquals(0, result.size());
    }

}