package com.dao.pojo.board;

import lombok.Data;

import java.util.List;

// 分页的实体类
@Data
public class PostsPageInfo<T> {
    private int page;//分页起始页
    private int size;//每页记录数
    private List<T> data;//返回的记录集合
    private long total;//总记录条数
}
