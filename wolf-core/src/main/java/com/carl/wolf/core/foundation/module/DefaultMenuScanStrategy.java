/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */

package com.carl.wolf.core.foundation.module;

import com.carl.wolf.core.bean.Menu;
import com.carl.wolf.core.exception.ScanException;
import com.carl.wolf.core.util.JSONUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 默认的菜单扫描路径，通过method进行反射扫描
 *
 * @author Carl
 * @date 2017/9/16
 * @since 1.0.0
 */
public class DefaultMenuScanStrategy implements IMenuScanStrategy {

    private static final Log logger = LogFactory.getLog(DefaultMenuScanStrategy.class);

    @Override
    public Menu process(Object target) throws ScanException {
        Method method = (Method) target;
        com.carl.wolf.core.annotation.Menu menu = method.getDeclaredAnnotation(com.carl.wolf.core.annotation.Menu.class);
        Menu menuVo = new Menu();
        menuVo.setIcon(menu.icon())
                .setOrder(menu.order())
                .setPath(menu.path())
                .setTitle(menu.title())
                .setTarget(target)
                .setPros(propertiesResolve(menu.pros()));
        return menuVo;
    }


    /**
     * 根据class反射获取对象放到map
     *
     * @param clz
     * @return
     */
    private Map<String, Object> propertiesResolve(Class[] clz) {
        Map<String, Object> pros = new HashMap<>();
        for (Class c : clz) {
            try {
                pros.putAll(JSONUtil.class2Map(c));
            } catch (Exception e) {
                logger.error("", e);
            }
        }
        return pros;
    }

    @Override
    public boolean support(Object target) {
        return target instanceof Method;
    }
}
