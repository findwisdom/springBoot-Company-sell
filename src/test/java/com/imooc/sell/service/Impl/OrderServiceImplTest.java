package com.imooc.sell.service.Impl;

import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Slf4j
public class OrderServiceImplTest {

    private final String BUYER_OPENID = "1XAEWSD";

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress("学习大街");
        orderDTO.setBuyerName("小木");
        orderDTO.setBuyerOpenid(BUYER_OPENID);
        orderDTO.setBuyerPhone("15123015948");
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setProductId(1);
        orderDetail1.setProductQuantity(2);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setProductId(2);
        orderDetail2.setProductQuantity(3);

        orderDetailList.add(orderDetail1);
        orderDetailList.add(orderDetail2);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);

        log.info("【创建订单】result={}", result);
        Assert.assertNotNull(result);


    }

    @Test
    public void findOne() {
    }

    @Test
    public void findList() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void paid() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void findList1() {
    }
}