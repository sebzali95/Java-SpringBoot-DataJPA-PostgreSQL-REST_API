package com.example.springboot.service;

import com.example.springboot.dto.HumanDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HumanService {


    HumanDto save(HumanDto humanDto);
    void delete(Long id);
    List<HumanDto> getAll();
    Page<HumanDto>getAll(Pageable pageable);
}
