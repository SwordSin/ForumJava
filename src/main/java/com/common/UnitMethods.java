package com.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dao.pojo.login.UserIpDetailedDO;
import com.github.kevinsawicki.http.HttpRequest;
import io.swagger.models.auth.In;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class UnitMethods {
//    public static String getRequestIp(HttpServletRequest request) {
//        String ip = request.getHeader("x-forwarded-for");
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("Proxy-Client-IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("WL-Proxy-Client-IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_CLIENT_IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getRemoteAddr();
//        }
//        return ip;
//    }

    // 发送get请求, 获取ip地址的城市
    public static String getIpCity(RestTemplate restTemplate, String ip) {
        Map<String, String> getParam = new HashMap<>();
        getParam.put("ak", "aXX2aHzly22z6k9YmXeqtBdPDBKEqakA");
        getParam.put("ip", ip);
        getParam.put("coor", "bd09ll");

        return null;
    }

    public static void main(String[] args) {
//        String url = "http://api.map.baidu.com/location/ip";
//        Map<String, String> getParam = new HashMap<>();
//        getParam.put("ak", "aXX2aHzly22z6k9YmXeqtBdPDBKEqakA");
//        getParam.put("ip", "60.233.1.30");
//        getParam.put("coor", "bd09ll");
//        HttpRequest httpRequest = HttpRequest.get(url, getParam, Boolean.TRUE);
//        String result = httpRequest.body();
//        UserIpDetailedDO userIpDetailedDO = JSONObject.parseObject(result, UserIpDetailedDO.class);
//        System.out.println(result);
//        System.out.println(userIpDetailedDO);
//        JSONObject jsonObject = (JSONObject) userIpDetailedDO.getContent().get("address_detail");
//        String  city = (String) jsonObject.get("city");
//        Integer cityCode = (Integer) jsonObject.get("city_code");
//        System.out.println(city);
//        System.out.println(cityCode);
    }
}
