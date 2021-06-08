package com.dao.pojo.bigdata;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("big_data")
public class BigDataDO {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Integer test6;
    private String test1;
    private String test2;
    private String test3;
    private String test4;
    private String test5;
}
