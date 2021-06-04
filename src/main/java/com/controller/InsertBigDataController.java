package com.controller;

import com.service.bigdata.InsertBigDataServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/dealBigData")
@Component
public class InsertBigDataController {
    @Resource
    InsertBigDataServiceImpl insertBigData;

    @ResponseBody
    @PutMapping("/insetBigData")
    public int insetBigData() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String , Object> map = new HashMap<>();
        map.put("aa", 2);
        list.add(map);
        insertBigData.insetBigData(list);
        return 1;
    }

    @ResponseBody
    @PutMapping("/insetBigData2")
    public Long insetBigData2(@RequestParam("size") int szie) {
        return insertBigData.insetBigData2(szie);
    }

}
