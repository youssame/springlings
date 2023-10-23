package com.youssefameachaq.uploadingfiles.controllers;

import com.youssefameachaq.uploadingfiles.services.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class FileUploadController {
    private final IStorageService IStorageService;

    @Autowired
    public FileUploadController(IStorageService IStorageService) {
        this.IStorageService = IStorageService;
    }

    @GetMapping("/")
    public String listUploadFiles(Model model) throws IOException {
        return "uploadForm";
    }
}
