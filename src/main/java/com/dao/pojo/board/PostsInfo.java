package com.dao.pojo.board;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("posts_info")
public class PostsInfo {
    @TableId(value = "posts_id", type = IdType.AUTO)
    private Integer postsId;
    private Integer boardId;
    private Integer postsAuthId;
    private String postsTitle;
    private String postsContent;
    private String postsAuthName;
    // 发布时间
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date publisDate;
    // 修改时间
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date modifyDate;
    private String param1;
    private String param2;
    private String param3;
    private String param4;
    private String param5;
    private String param6;

}
