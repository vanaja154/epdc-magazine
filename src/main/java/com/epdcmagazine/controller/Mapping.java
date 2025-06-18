package com.epdcmagazine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping;

import com.epdcmagazine.entity.Magazine;
import com.epdcmagazine.service.MagazineService;

@Controller
public class Mapping {

    @Autowired
    private MagazineService magazineService;

    @GetMapping("/")
    public String showHomePage(Model model) {
        Magazine magazine = magazineService.getLatestContent();

        if (magazine == null) {
            System.out.println("Epaper is null");
        } else {
            System.out.println("Magazine loaded: " + magazine);
        }

        if (magazine != null) {
            String imageBaseUrl = "https://admin.epdcindia.com/uploads/";
            String pdfBaseUrl = "https://admin.epdcindia.com/uploads/";

            magazine.setEdition1Image(constructFileUrl(magazine.getEdition1Image(), imageBaseUrl));
            magazine.setEdition1PdfFile(constructFileUrl(magazine.getEdition1PdfFile(), pdfBaseUrl));
            magazine.setEdition2Image(constructFileUrl(magazine.getEdition2Image(), imageBaseUrl));
            magazine.setEdition2PdfFile(constructFileUrl(magazine.getEdition2PdfFile(), pdfBaseUrl));
            magazine.setAdvertisementImage(constructFileUrl(magazine.getAdvertisementImage(), imageBaseUrl));
        }

        model.addAttribute("magazine", magazine); 
        return "magazine";
    }

    private String constructFileUrl(String filePath, String baseUrl) {
        if (filePath == null || filePath.isEmpty()) {
            return "";
        }
        return baseUrl + filePath.replace("\\", "/");
    }
}
