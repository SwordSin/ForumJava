package com.dao.pojo.board;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

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
    private String param1;
    private String param2;
    private String param3;
    private String param4;
    private String param5;
    private String param6;

}
