package com.epdcmagazine.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.epdcmagazine.entity.Magazine;

public interface MagazineRepository extends MongoRepository<Magazine, String> {
    Magazine findFirstByOrderByIdDesc();

    List<Magazine> findByDate(Date date);


    @Query("{ $expr: { $eq: [ { $month: '$date' }, ?0 ] } }")
    List<Magazine> findByMonth(int month);


}
