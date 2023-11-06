package com.example.parser_hh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SearchFilter {
    private String experience; // Опыт работы (between1And3 / between3And6 / moreThan6 / noExperience)
    private String employment; // Тип занятости (full /  part / project / probation / volunteer)
    private String schedule; // График работы (fullDay / flexible / shift / remote / flyInFlyOut)
    private String text; // Текс введённое в поле поиска
}
