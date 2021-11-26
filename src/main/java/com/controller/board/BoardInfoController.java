package com.controller.board;

import com.dao.pojo.board.BoardInfo;
import com.service.board.BoardInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
