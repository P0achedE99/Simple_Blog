package com.qingcen.poachedegg.myblog.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("message")
public class Message {
    private Integer id;
    @JsonProperty("account")
    private String userAccount;
    @JsonProperty("password")
    private String userPassword;
    private String userName;
    private String message;
}
