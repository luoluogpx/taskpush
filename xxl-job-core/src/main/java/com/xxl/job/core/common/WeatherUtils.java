package com.xxl.job.core.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xxl.job.core.dao.Weather;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:  天气工具类
 * @author g p x
 * @date 2022/8/22 18:43
 */
public class WeatherUtils {

    public static void main(String[] args) {
        System.out.println(getWeather());
    }
    public static Weather getWeather(){
        RestTemplate restTemplate = new RestTemplate();
        Map<String,String> map = new HashMap<String,String>();
        // 本人所在地-地方行政代码
        map.put("district_id","110108");
        //这个是数据类型
        map.put("data_type","all");
        //百度开放平台AK
        map.put("ak","F7YBs9G2OQC1Q5F60Mwp5GcipBtDL97T");
        String res = restTemplate.getForObject(
                "https://api.map.baidu.com/weather/v1/?district_id={district_id}&data_type={data_type}&ak={ak}",
                String.class,
                map);
        JSONObject json = JSONObject.parseObject(res);
        JSONArray forecasts = json.getJSONObject("result").getJSONArray("forecasts");
        List<Weather> weathers = forecasts.toJavaList(Weather.class);
        JSONObject now = json.getJSONObject("result").getJSONObject("now");
        Weather weather = weathers.get(0);
        weather.setText_now(now.getString("text"));
        weather.setTemp(now.getString("temp"));
        weather.setWind_class(now.getString("wind_class"));
        weather.setWind_dir(now.getString("wind_dir"));
        return weather;
    }

}
