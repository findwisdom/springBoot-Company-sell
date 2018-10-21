package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.awt.print.Pageable;
import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class OrderMasterRepositoryTest {

    private final String OPENID = "1XAEWSD";

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1111xx");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("123456789123");
        orderMaster.setBuyerAddress("幕课网");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.5));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest request = new PageRequest(0, 2);
        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID, request);
        Assert.assertNotEquals(0, result.getTotalElements());
    }
}