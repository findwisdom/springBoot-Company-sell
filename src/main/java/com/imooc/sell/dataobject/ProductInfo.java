package com.imooc.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Data
public class ProductInfo extends BaseEntity{
    /** 产品名称 */
    private String productName;

    /** 产品价格 */
    private BigDecimal productPrice;

    /** 产品库存 */
    private Integer productStock;

    /** 产品描述 */
    private String productDescription;

    /** 产品图标 */
    private String productIcon;

    /** 产品状态  0: 正常  1: 下架*/
    private Integer productStatus;

    /** 类目编号 */
    private Integer categoryType;

}
