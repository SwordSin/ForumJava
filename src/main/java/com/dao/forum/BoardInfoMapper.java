package com.dao.forum;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dao.pojo.board.BoardInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardInfoMapper extends BaseMapper<BoardInfo> {
}
