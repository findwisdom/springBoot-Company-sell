package com.imooc.sell.dataobject;

import com.google.gson.Gson;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    private static Gson gson = new Gson();

    @Id
    @GeneratedValue
    private Integer id;

    @CreatedDate
    private Date createDate;

    @LastModifiedDate
    private Date updateDate;

    @Override
    public String toString() {
        return gson.toJson(this);
    }
}
