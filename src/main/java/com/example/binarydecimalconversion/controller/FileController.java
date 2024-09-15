package com.example.binarydecimalconversion.controller;
//import com.example.demo.service.FileService;
import com.example.binarydecimalconversion.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping("/")
    public String index() {
        return "upload";  // The file upload form
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
        try {
            String result = fileService.processFile(file);
            model.addAttribute("result", result);  // Add the result to the model
            return "result";  // Display the result
        } catch (IOException e) {
            model.addAttribute("message", "Error processing the file: " + e.getMessage());
            return "upload";  // Return to the form in case of error
        }
    }
}
