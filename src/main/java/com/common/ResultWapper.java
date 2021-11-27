package com.common;

// 对于返回结果的包装类
public class ResultWapper<T> {
    private int status; // 响应状态
    private T data; // 响应结果

    private ResultWapper(int status, T data) {
        this.data = data;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }

    public T getData() {
        return data;
    }

//    public void setData(T data) {
//        this.data = data;
//    }

    public static<T> ResultWapper getResult(int status, T data){
        return new ResultWapper<T>(status, data);
    }
}
