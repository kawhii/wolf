/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */

/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */

package com.carl.wolf.permission.controller;

import org.pac4j.core.context.J2EContext;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.core.profile.ProfileManager;
import org.pac4j.jwt.profile.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author Carl
 * @date 2017/9/16
 * @since 1.0.0
 */
@RestController
public class IndexController {

    @Autowired
    private JwtGenerator generator;

    @GetMapping("/")
    public Object index() {
        return "index page";
    }

    @GetMapping("/user/{id}")
    public Object user(@PathVariable(value = "id") String id) {
        return "users page:" + id;
    }

    @GetMapping("/user/detail")
    public Object detail(HttpServletRequest request) {
        return "users:" + request.getUserPrincipal().getName();
    }

    @RequestMapping("/user/login")
    public Object login(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<>();
        J2EContext context = new J2EContext(request, response);
        String token = "";
        final ProfileManager manager = new ProfileManager(context);
        final Optional<CommonProfile> profile = manager.get(true);
        if (profile.isPresent()) {
            token = generator.generate(profile.get());
        }
        model.put("token", token);
        return new HttpEntity<>(model);
    }
}
