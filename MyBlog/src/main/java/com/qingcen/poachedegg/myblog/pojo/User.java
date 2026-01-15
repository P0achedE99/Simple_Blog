package com.qingcen.poachedegg.myblog.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.apache.ibatis.type.Alias;


@Data
@Alias("user")
public class User {
    private Integer id;
    @JsonProperty("account")
    private String userAccount;
    private String userName;
    @JsonProperty("password")
    private String userPassword;
    private Integer permission;
}
