package com.imooc.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by 廖师兄
 * 2017-06-11 17:20
 */
@Entity
@Data
public class OrderDetail extends BaseTimeEntity{

    /** 订单id. */
    private Integer orderId;

    /** 商品id. */
    private Integer productId;

    /** 商品名称. */
    private String productName;

    /** 商品单价. */
    private BigDecimal productPrice;

    /** 商品数量. */
    private Integer productQuantity;

    /** 商品小图. */
    private String productIcon;
}
