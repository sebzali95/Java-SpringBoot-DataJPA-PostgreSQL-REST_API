package com.example.springboot.controller;

import com.example.springboot.dto.HumanDto;
import com.example.springboot.service.HumanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kisi")
@RequiredArgsConstructor
public class HumanController {

    private final HumanService humanService;

    @PostMapping
    public ResponseEntity<HumanDto> kaydet(@RequestBody HumanDto humanDto) {
       return ResponseEntity.ok(humanService.save(humanDto));
    }

    @GetMapping
    public ResponseEntity<List<HumanDto>>tumunuListele(){
        return ResponseEntity.ok(humanService.getAll());
    }
}
