package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Slf4j
public class OrderDetailRepositoryTest {


    private OrderDetailRepository repository;

    @Test
    public void saveTest () {
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setOrderId("1111xx");
        orderDetail.setProductId(1);
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(3.20));
        orderDetail.setProductQuantity(2);
        orderDetail.setProductIcon("http://xxxx.jpa");

        OrderDetail result = repository.save(orderDetail);
        System.out.println(result);


        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> result = repository.findByOrderId("1111xx");
        Assert.assertNotEquals(0, result.size());
    }
}