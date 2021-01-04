package com.gyubong.fileviewer.system;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.util.ArrayList;

@Controller
public class HelloController {

    @GetMapping("/hi")
    public String helloPage() {

        return "hello";
    }
}
