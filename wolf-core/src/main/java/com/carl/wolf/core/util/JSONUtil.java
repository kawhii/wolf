/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */


package com.carl.wolf.core.util;

import com.carl.wolf.core.exception.CoreException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

/**
 * json处理工具类
 *
 * @author Carl
 * @date 2017/9/16
 * @since 1.0.0
 */
public class JSONUtil {
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * 对象转换成json
     *
     * @param obj 对象
     * @return
     */
    public static String toJSONStr(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new CoreException("", e);
        }
    }

    /**
     * 对象转json
     *
     * @param obj
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T toJSONObj(Object obj, Class<T> clazz) {
        try {
            return mapper.readValue(obj instanceof String ? (String) obj : toJSONStr(obj), clazz);
        } catch (IOException e) {
            throw new CoreException("", e);
        }
    }

    /**
     * 对象转json
     *
     * @param obj
     * @return
     */
    public static Map obj2Map(Object obj) {
        return toJSONObj(obj, Map.class);
    }

    /**
     * 类直接转json对象
     *
     * @param clz
     * @return
     */
    public static Map class2Map(Class<? extends Serializable> clz) throws IllegalAccessException, InstantiationException {
        return obj2Map(clz.newInstance());
    }
}
