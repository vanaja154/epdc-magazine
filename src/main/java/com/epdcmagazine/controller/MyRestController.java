package com.epdcmagazine.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epdcmagazine.entity.Magazine;
import com.epdcmagazine.service.MagazineService;

@RestController
public class MyRestController {

    @Autowired
    private MagazineService magazineService;

    /**
     * API endpoint to get documents by date.
     *
     * @param date The date to filter the documents (format: yyyy-MM-dd).
     * @return A list of Epaper objects matching the given date.
     */
    // @GetMapping("/getbydate")
    // public List<Magazine> getPaperByDate(
    //         @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {

    //     // Call the service method to fetch editions by date
    //     return magazineService.getEditionsByDate(date);
    // }
  @GetMapping("/getbymonth")
public List<Magazine> getPaperByMonth(@RequestParam("month") int month) {
    return magazineService.getEditionsByMonth(month);
}

    @GetMapping("/getlatestcontent")
    public Magazine getPaperByDate() {

        return magazineService.getLatestContent();

    }
}