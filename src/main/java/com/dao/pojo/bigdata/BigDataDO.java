package com.dao.pojo.bigdata;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("big_data")
public class BigDataDO {
    @TableId(value = "order_number", type = IdType.AUTO)
    // 订单编号
    private Long orderNumber;
    // 消费者id
    private Long costomerId;
    // 商品名
    private String commodity;
    // 商品编号
    private int commodityId;
    // 价格
    private float price;
    // 折扣
    private float discount;
    // 订单时间
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date orderTime;
    // 支付时间
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date payTime;
}
