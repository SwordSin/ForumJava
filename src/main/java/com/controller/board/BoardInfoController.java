package com.controller.board;

import com.common.ResultWapper;
import com.dao.pojo.board.BoardInfo;
import com.dao.pojo.board.PostsInfo;
import com.dao.pojo.board.PostsPageInfo;
import com.service.board.BoardInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

// 板块相关的接口
@Controller
@RequestMapping("/board")
public class BoardInfoController {

    @Resource
    BoardInfoService boardInfoService;

    // 获取board的内容
    @ResponseBody
    @GetMapping("/getBoardInfo")
    public List<BoardInfo> getBoardInfo() {
        return boardInfoService.getBoardInfo();
    }

    // 保存帖子内容
    @ResponseBody
    @PostMapping("/savePostsInfo")
    public ResultWapper<String> savePostsInfo(@RequestBody PostsInfo postsInfo) {
        return boardInfoService.savePostsInfo(postsInfo);
    }

    // 获取获取分页帖子内容
    @ResponseBody
    @GetMapping("/getPagePostsInfo")
    public ResultWapper<PostsPageInfo<PostsInfo>> getPagePostsInfo(int page, int size, int boardId) {
        return boardInfoService.getPagePostsInfo(page, size, boardId);
    }

    // 获取单个帖子的内容
    @ResponseBody
    @GetMapping("/getPostsInfoOne")
    public ResultWapper<PostsInfo> getPostInfoOne(int postsId) {
        return boardInfoService.getPostsInfoOne(postsId);
    }


}
