package com.service.board.impl;

import com.dao.forum.BoardInfoMapper;
import com.dao.pojo.board.BoardInfo;
import com.service.board.BoardInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BoardInfoServiceImpl implements BoardInfoService {

    @Resource
    BoardInfoMapper boardInfoMapper;

    @Override
    public List<BoardInfo> getBoardInfo() {
        // 获取boardInfo的所有数据
        return boardInfoMapper.selectList(null);
    }
}
