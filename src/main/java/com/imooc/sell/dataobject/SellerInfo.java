package com.imooc.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class SellerInfo extends BaseEntity {

    private String username;

    private String password;

    private String openid;

}
