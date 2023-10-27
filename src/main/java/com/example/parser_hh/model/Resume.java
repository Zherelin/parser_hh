package com.example.parser_hh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Resume {
    private String title;
    private String age;
    private String salary;
    private String status;
    private String experience;
    private String previousWork;
    private String link;
}
