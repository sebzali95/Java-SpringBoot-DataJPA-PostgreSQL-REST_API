package com.example.springboot.dto;

import lombok.Data;

import java.util.List;

@Data
public class HumanDto {


    private Long id;

    private String name;

    private String surname;

    private List<String> adresleri;
}
