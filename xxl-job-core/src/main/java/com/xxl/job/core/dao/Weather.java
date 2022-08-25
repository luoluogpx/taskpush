package com.xxl.job.core.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:天气的实体类
 * @author g p x
 * @date 2022/8/22 18:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
    String wd_night;

    String date;

    String high;

    String week;

    String text_night;

    String wd_day;

    String low;

    String wc_night;

    String text_day;

    String wc_day;
    /**
    * @Date: 2022/8/22 18:39
    * @Description:  当前天气
    */
    String text_now;
    /**
     * @Date: 2022/8/22 18:39
     * @Description:  当前温度
     */
    String temp;
    /**
     * @Date: 2022/8/22 18:39
     * @Description:  风级大
     */
    String wind_class;
    /**
     * @Date: 2022/8/22 18:39
     * @Description:  风向
     */
    String wind_dir;
}

