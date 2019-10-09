package com.example.translator.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("")
    public String home() {
        return "index.html";
    }

    @RequestMapping("/r")
    public String reception() {
//        return "reception.html";
        return "index.html";
    }

    @RequestMapping("/style/{file}")
    public String fileCss(@PathVariable("file") String fileName) {
        return fileName + ".css";
    }

}
