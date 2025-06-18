package com.epdcmagazine.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epdcmagazine.entity.Magazine;
import com.epdcmagazine.repository.MagazineRepository;

@Service
public class MagazineService {

    @Autowired
    private MagazineRepository contentRepository;

    public List<Magazine> getAllContent() {
        return contentRepository.findAll();
    }

    public List<Magazine> getEditionsByDate(Date date) {
        return contentRepository.findByDate(date);
    }

    public Magazine getLatestContent() {
        return contentRepository.findFirstByOrderByIdDesc();
    }

    public List<Magazine> getEditionsByMonth(int month) {
    return contentRepository.findByMonth(month);
}

}
