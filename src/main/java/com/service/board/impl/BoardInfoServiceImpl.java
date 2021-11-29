package com.service.board.impl;

import com.common.ResultWapper;
import com.dao.forum.BoardInfoMapper;
import com.dao.forum.PostsInfoMapper;
import com.dao.pojo.board.BoardInfo;
import com.dao.pojo.board.PostsInfo;
import com.dao.pojo.board.PostsPageInfo;
import com.service.board.BoardInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardInfoServiceImpl implements BoardInfoService {

    @Resource
    BoardInfoMapper boardInfoMapper;

    @Resource
    PostsInfoMapper postsInfoMapper;

    @Override
    public List<BoardInfo> getBoardInfo() {
        // 获取boardInfo的所有数据
        return boardInfoMapper.selectList(null);
    }

    @Override
    public ResultWapper<String> savePostsInfo(PostsInfo postsInfo) {
        int result = postsInfoMapper.insert(postsInfo);
        ResultWapper<String> resultWapper = null;
        if (result == 1) {
            resultWapper = ResultWapper.getResult(1, postsInfo.getPostsId().toString());
        } else {
            resultWapper = ResultWapper.getResult(0, "发生错误");
        }
        return resultWapper;
    }

    @Override
    public ResultWapper<PostsPageInfo<PostsInfo>> getPagePostsInfo(int page, int size, int boardId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("page", (page-1)*size);
        params.put("size", size);
        params.put("boardId", boardId);
        List<PostsInfo> postsInfos = postsInfoMapper.findPostsByPage(params);
        Long pageTotal = postsInfoMapper.findUserCount();

        // 创建posts的分页的实体类
        PostsPageInfo<PostsInfo> pageInfo = new PostsPageInfo<>();
        pageInfo.setData(postsInfos);
        pageInfo.setTotal(pageTotal);

        // 获取结果类
        return ResultWapper.getResult(1, pageInfo);
    }

    @Override
    public ResultWapper<PostsInfo> getPostsInfoOne(int postsId) {
        PostsInfo postsInfo = postsInfoMapper.selectById(postsId);
        return ResultWapper.getResult(1, postsInfo);
    }
}
