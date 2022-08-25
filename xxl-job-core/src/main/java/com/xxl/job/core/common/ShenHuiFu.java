package com.xxl.job.core.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述:对接天行数据（彩虹屁）api的工具类
 * @author g p x
 * @date 2022/8/22 18:45
 */
public class ShenHuiFu {
    public static String getShenHuiFu() {
        //接口地址?key=接口的APIKEY
        String httpUrl = "http://api.tianapi.com/godreply/index?key=e4cb229b4aff7a7ed9b3f96282ba903f";
//        String httpUrl = "http://api.tianapi.com/caihongpi/index?key=e4cb229b4aff7a7ed9b3f96282ba903f";
//        String httpUrl = "http://api.tianapi.com/dujitang/index?key=e4cb229b4aff7a7ed9b3f96282ba903f";
//        String httpUrl = "http://api.tianapi.com/pyqwenan/index?key=e4cb229b4aff7a7ed9b3f96282ba903f";
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSONObject.parseObject(result);
        JSONArray newslist = jsonObject.getJSONArray("newslist");
        String content = newslist.getJSONObject(0).getString("content");
        return content;
    }

    public static Map<String,String> getEnsentence() {
        //接口地址?key=接口的APIKEY
        String httpUrl = "http://api.tianapi.com/godreply/index?key=e4cb229b4aff7a7ed9b3f96282ba903f";
//        String httpUrl = "http://api.tianapi.com/caihongpi/index?key=e4cb229b4aff7a7ed9b3f96282ba903f";
//        String httpUrl = "http://api.tianapi.com/dujitang/index?key=e4cb229b4aff7a7ed9b3f96282ba903f";
//        String httpUrl = "http://api.tianapi.com/pyqwenan/index?key=e4cb229b4aff7a7ed9b3f96282ba903f";
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSONObject.parseObject(result);
        JSONArray newslist = jsonObject.getJSONArray("newslist");
        String content = newslist.getJSONObject(0).getString("content");
        String title = newslist.getJSONObject(0).getString("title");
        Map<String, String> map = new HashMap<>();
        map.put("content",content);
        map.put("title",title);
        return map;
    }
}
