package com.dao.forum;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dao.pojo.board.PostsInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PostsInfoMapper extends BaseMapper<PostsInfo>{
    // 添加分页方法
    List<PostsInfo> findPostsByPage(Map<String, Object> map);
    long findUserCount();
}
