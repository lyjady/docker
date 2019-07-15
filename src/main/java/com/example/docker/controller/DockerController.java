package com.example.docker.controller;

import com.example.docker.annotation.CacheLock;
import com.example.docker.annotation.CacheParameter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author linyongjin
 * @date 2019/7/9 16:59
 */
@RestController
public class DockerController {

    @CacheLock(lockName = "docker", timeout = 256L)
    @RequestMapping("/docker")
    public Map<String, String> docker(@RequestParam(value = "value", required = false)
                                          @CacheParameter(parameterName = "valueName") String value) {
        Map<String, String> map = new HashMap<>();
        map.put("message", "Hello Docker");
        return map;
    }
}
