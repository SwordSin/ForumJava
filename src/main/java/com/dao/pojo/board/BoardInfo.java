package com.dao.pojo.board;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Value;

@Data
@TableName("board_info")
public class BoardInfo {
    @TableId(value="board_id", type = IdType.AUTO)
    private Integer boardId;
    private String boardName;
    private String param1;
    private String param2;
    private String param3;
    private String param4;
}
