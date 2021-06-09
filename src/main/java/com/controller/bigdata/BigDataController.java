package com.controller.bigdata;

import com.dao.pojo.bigdata.BigDataDO;
import com.service.bigdata.DeleteBigDataService;
import com.service.bigdata.impl.GetBigDataServiceImpl;
import com.service.bigdata.impl.InsertBigDataServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/dealBigData")
@Component
public class BigDataController {
    @Resource
    InsertBigDataServiceImpl insertBigData;
    @Resource
    GetBigDataServiceImpl getBigDataService;
    @Resource
    DeleteBigDataService deleteBigDataService;

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

    @ResponseBody
    @GetMapping("/getBigData")
    public List<BigDataDO> getBigData() {
        return getBigDataService.getBigDataAll();
    }

    @ResponseBody
    @DeleteMapping("/deleteBigDataAll")
    public int deleteBigDataAll() {
        return deleteBigDataService.deleteBigDataAll();
    }


    public static void main(String[] args) {

    }
}
