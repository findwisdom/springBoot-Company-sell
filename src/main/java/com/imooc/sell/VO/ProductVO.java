package com.imooc.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品(包含类目)
 * Created by 廖师兄
 * 2017-05-12 14:20
 */
@Data
@ApiModel(value = "ProductVO", description = "商品类型")
public class ProductVO {

    @JsonProperty("name")
    @ApiModelProperty(value = "类目名称", name="name", dataType = "String", example="女生最爱")
    private String categoryName;

    @JsonProperty("type")
    @ApiModelProperty(value = "类目编号", name="type", dataType = "Integer")
    private Integer categoryType;

    @JsonProperty("foods")
    @ApiModelProperty(value = "食物列表", name="foods", dataType = "List")
    private List<ProductInfoVO> productInfoVOList;
}
