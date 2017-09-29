/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */

package com.carl.wolf.core;

import com.carl.wolf.core.exception.CoreException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    public static String toJSonStr(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new CoreException("", e);
        }
    }
}
