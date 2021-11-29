package com.service.board;

import com.common.ResultWapper;
import com.dao.pojo.board.BoardInfo;
import com.dao.pojo.board.PostsInfo;
import com.dao.pojo.board.PostsPageInfo;

import java.util.List;

public interface BoardInfoService {
    List<BoardInfo> getBoardInfo();

    // 获取save
    ResultWapper<String> savePostsInfo(PostsInfo postsInfo);
    // 获取帖子
    ResultWapper<PostsPageInfo<PostsInfo>> getPagePostsInfo(int page, int size, int boardId);
    // 获取帖子
    ResultWapper<PostsInfo> getPostsInfoOne(int postsId);

}
