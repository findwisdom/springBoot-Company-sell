package com.imooc.sell.dataobject;

import com.google.gson.Gson;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class BaseOnlyTimeEnity {
    private static Gson gson = new Gson();

//    @Id
//    private String id;

    @CreatedDate
    private Date createDate;

    @LastModifiedDate
    private Date updateDate;

    @Override
    public String toString() {
        return gson.toJson(this);
    }
}
