package com.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/demo")
public class DemoController {
	@ResponseBody
    @RequestMapping("/index")
	@ApiOperation(value="index...", httpMethod="POST", notes="demo2 index...")
	@ApiImplicitParam(name="lala", value="haha", dataType="String", required=true, paramType="apiKey")
    public String index(){
		System.out.println("demo");
        return "demo";
    }
}
