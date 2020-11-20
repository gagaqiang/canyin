package com.ruoyi.common.utils.uuid;

import com.ruoyi.common.utils.uuid.UUID;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ID生成器工具类
 * 
 * @author ruoyi
 */
public class IdUtils {

    private static SimpleDateFormat time15 = new SimpleDateFormat("yyyyMMddHHmmssSSS");


    /**
     * 获取随机UUID
     * 
     * @return 随机UUID
     */
    public static String randomUUID()
    {
        return UUID.randomUUID().toString();
    }

    /**
     * 简化的UUID，去掉了横线
     * 
     * @return 简化的UUID，去掉了横线
     */
    public static String simpleUUID()
    {
        return UUID.randomUUID().toString(true);
    }

    /**
     * 获取随机UUID，使用性能更好的ThreadLocalRandom生成UUID
     * 
     * @return 随机UUID
     */
    public static String fastUUID()
    {
        return UUID.fastUUID().toString();
    }

    /**
     * 简化的UUID，去掉了横线，使用性能更好的ThreadLocalRandom生成UUID
     * 
     * @return 简化的UUID，去掉了横线
     */
    public static String fastSimpleUUID()
    {
        return UUID.fastUUID().toString(true);
    }


    /**
     * 获取时分秒格式化
     * @return
     */
    public static String getID(){
        return time15.format(new Date());
    }


}
