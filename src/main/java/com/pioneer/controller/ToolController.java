package com.pioneer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/tool")
public class ToolController {

    @RequestMapping("/ok")
    @ResponseBody
    public String ok() {
        return "ok";
    }
}  