package com.example.springbootdocker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DockerController {

    @RequestMapping("/docker")
    public String docker(){
        log.info("hello docker!");
        return "hello docker! 我是 master 分支。。。。";
    }
}
