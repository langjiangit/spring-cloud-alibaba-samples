package com.yuhb.provider.controller;

import com.yuhb.common.domain.TbUser;
import com.yuhb.provider.mapper.TbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yu.hb on 2019-10-30
 */
@RestController
public class ProviderController {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Value("${server.port}")
    private Integer port;


    @GetMapping("/feign/echo")
    public String feignEcho(String name) {
        return "feignEcho() hi " + name;
    }

    @GetMapping("/feign/user/add")
    public String add(String name) {
        tbUserMapper.insert(new TbUser("provider",2));
        return "success";
    }

    @GetMapping("/port")
    public Integer port() {
        return port;
    }
}
