package com.gyubong.fileviewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.util.ArrayList;

@Controller
public class DashBoardController {

    @GetMapping("/dashboard")
    public String dashboardPage(Model model) {

        model.addAttribute("username", "erick.acabal");
        model.addAttribute("position", "User");
        model.addAttribute("files", getFileListing());

        return "dashboard";
    }

    private ArrayList getFileListing() {
        //C:\Users\Tmax\springMVC
        File dir = new File("C:/Users/Tmax");
        File[] files = dir.listFiles();

        ArrayList filPaths = new ArrayList();
        for (File file : files) {
            filPaths.add(file.getAbsolutePath());
        }
        return filPaths;
    }
}
