package com.example.demo.repository;

import com.example.demo.models.Auto;
import org.springframework.data.repository.CrudRepository;

public interface AutoRepository extends CrudRepository<Auto, Long> {
    Auto findByNumber(String number);
}
